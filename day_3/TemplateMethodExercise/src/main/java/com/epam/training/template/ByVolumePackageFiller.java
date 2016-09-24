package com.epam.training.template;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.epam.training.template.data.Package;
import com.epam.training.template.service.PackageSender;

public class ByVolumePackageFiller implements PackageFiller {

    private final BigDecimal totalVolume;

    private BigDecimal usedVolume;

    private Set<Package> notFit = new HashSet<Package>();

    private Set<Package> inPackage = new HashSet<Package>();

    private PackageSender packageSender;

    public ByVolumePackageFiller(PackageSender packageSender, BigDecimal totalWeight) {
        this.totalVolume = totalWeight;
        this.packageSender = packageSender;
        this.usedVolume = BigDecimal.ZERO;
    }

    @Override
    public void reset() {
        this.notFit.clear();
        this.inPackage.clear();
        this.usedVolume = BigDecimal.ZERO;
    }

    @Override
    public void process(Set<Package> packages) {
        List<Package> remainingPackages = new ArrayList<Package>(packages);
        while (remainingPackages.size() > notFit.size()) {
            Package currentPackage = remainingPackages.get(0);
            if (currentPackage.getVolume().add(usedVolume).compareTo(totalVolume) <= 0) {
                remainingPackages.remove(currentPackage);
                inPackage.add(currentPackage);
                usedVolume = usedVolume.add(currentPackage.getVolume());
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
