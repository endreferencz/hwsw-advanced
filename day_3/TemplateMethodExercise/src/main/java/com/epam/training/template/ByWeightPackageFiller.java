package com.epam.training.template;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.epam.training.template.data.Package;
import com.epam.training.template.service.PackageSender;

public class ByWeightPackageFiller implements PackageFiller {

    private final BigDecimal totalWeight;

    private BigDecimal usedWeight;

    private Set<Package> notFit = new HashSet<Package>();

    private Set<Package> inPackage = new HashSet<Package>();

    private PackageSender packageSender;

    public ByWeightPackageFiller(PackageSender packageSender, BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
        this.packageSender = packageSender;
        this.usedWeight = BigDecimal.ZERO;
    }

    @Override
    public void reset() {
        this.notFit.clear();
        this.inPackage.clear();
        this.usedWeight = BigDecimal.ZERO;
    }

    @Override
    public void process(Set<Package> packages) {
        List<Package> remainingPackages = new ArrayList<Package>(packages);
        while (remainingPackages.size() > notFit.size()) {
            Package currentPackage = remainingPackages.get(0);
            if (currentPackage.getWeight().add(usedWeight).compareTo(totalWeight) <= 0) {
                remainingPackages.remove(currentPackage);
                inPackage.add(currentPackage);
                usedWeight = usedWeight.add(currentPackage.getWeight());
            } else {
                notFit.add(currentPackage);
                remainingPackages.remove(0);
                remainingPackages.add(currentPackage);
            }
        }
    }

    @Override
    public Set<Package> getNotFit() {
        return Collections.unmodifiableSet(notFit);
    }

    @Override
    public Set<Package> getInPackage() {
        return Collections.unmodifiableSet(inPackage);
    }

    @Override
    public void sendFit() {
        packageSender.sendPackages(inPackage);
    }

}
