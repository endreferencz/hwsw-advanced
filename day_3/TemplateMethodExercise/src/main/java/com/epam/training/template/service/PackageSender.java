package com.epam.training.template.service;

import java.util.Set;

import com.epam.training.template.data.Package;

public interface PackageSender {

    void sendPackages(Set<Package> packages);

}
