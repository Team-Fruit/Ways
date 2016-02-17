package com.kamesuta.mc.ways.util.vector;

public class Vector4f extends Vector3f implements Vector4 {
	public float w;

	public Vector4f() {
		this(0, 0, 0, 0);
	}

	public Vector4f(Vector4f vec) {
		this(vec.x, vec.y, vec.z, vec.w);
	}

	public Vector4f(float num) {
		this(num, num, num, num);
	}

	public Vector4f(float x, float y, float z, float w) {
		super(x, y, z);
		this.w = w;
	}

	public final float getW() {
		return this.w;
	}

	public final void setW(float w) {
		this.w = w;
	}

	public Vector4f set(Vector4f vec) {
		return set(vec.x, vec.y, vec.z, vec.w);
	}

	public Vector4f set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return this;
	}

	@Override
	public float lengthSquared() {
		return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
	}

	public final double lengthTo(Vector4f vec) {
		return Math.sqrt(lengthSquaredTo(vec));
	}

	public float lengthSquaredTo(Vector4f vec) {
		return pow2(this.x - vec.x) + pow2(this.y - vec.y) + pow2(this.z - vec.z) + pow2(this.w - vec.w);
	}

	@Override
	public Vector4f negate() {
		this.x = -this.x;
		this.y = -this.y;
		this.z = -this.z;
		this.w = -this.w;
		return this;
	}

	public float dot(Vector4f vec) {
		return this.x * vec.x + this.y * vec.y + this.z * vec.z + this.w * vec.w;
	}

	@Override
	public Vector4f scale(double scale) {
		this.x *= scale;
		this.y *= scale;
		this.z *= scale;
		this.w *= scale;
		return this;
	}

	public Vector4f add(Vector4f vec) {
		this.x += vec.x;
		this.y += vec.y;
		this.z += vec.z;
		this.w += vec.w;
		return this;
	}

	public Vector4f add(float x, float y, float z, float w) {
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}

	public Vector4f sub(Vector4f vec) {
		this.x -= vec.x;
		this.y -= vec.y;
		this.z -= vec.z;
		this.w -= vec.w;
		return this;
	}

	public Vector4f sub(float x, float y, float z, float w) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		return this;
	}

	@Override
	public Vector4i toVector4i() {
		return new Vector4i((int) Math.floor(this.x), (int) Math.floor(this.y), (int) Math.floor(this.z),
				(int) Math.floor(this.w));
	}

	@Override
	public Vector4i toVector4i(Vector4i vec) {
		return vec.set((int) Math.floor(this.x), (int) Math.floor(this.y), (int) Math.floor(this.z),
				(int) Math.floor(this.w));
	}

	@Override
	public Vector4l toVector4l() {
		return new Vector4l((long) Math.floor(this.x), (long) Math.floor(this.y), (long) Math.floor(this.z),
				(long) Math.floor(this.w));
	}

	@Override
	public Vector4l toVector4l(Vector4l vec) {
		return vec.set((long) Math.floor(this.x), (long) Math.floor(this.y), (long) Math.floor(this.z),
				(long) Math.floor(this.w));
	}

	@Override
	public Vector4f toVector4f() {
		return this;
	}

	@Override
	public Vector4f toVector4f(Vector4f vec) {
		return vec.set(this.x, this.y, this.z, this.w);
	}

	@Override
	public Vector4d toVector4d() {
		return new Vector4d(this.x, this.y, this.z, this.w);
	}

	@Override
	public Vector4d toVector4d(Vector4d vec) {
		return vec.set(this.x, this.y, this.z, this.w);
	}

	@Override
	public Vector4f clone() {
		return new Vector4f(this);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Vector4f && equals((Vector4f) obj);
	}

	public boolean equals(Vector4f vec) {
		return equals(vec, FLOAT_EPSILON);
	}

	public boolean equals(Vector4f vec, float epsilon) {
		return Math.abs(this.x - vec.x) < epsilon && Math.abs(this.y - vec.y) < epsilon
				&& Math.abs(this.z - vec.z) < epsilon && Math.abs(this.w - vec.w) < epsilon;
	}

	@Override
	public String toString() {
		return String.format("[%s, %s, %s, %s]", this.x, this.y, this.z, this.w);
	}
}
