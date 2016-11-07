package com.epam.training;

public final class Point {

	private final double x;

	private final double y;

	private final double z;

	private final double w;

	public Point(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public double getW() {
		return w;
	}

}
