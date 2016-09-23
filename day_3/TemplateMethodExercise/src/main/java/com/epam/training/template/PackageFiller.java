package com.epam.training.template;

import java.util.Set;

import com.epam.training.template.data.Package;

public interface PackageFiller {

    void reset();

    void process(Set<Package> packages);

    Set<Package> getNotFit();

    Set<Package> getInPackage();

    void sendFit();

}
