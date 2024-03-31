package engine.geometric;

public class Vector3 {

    public double x;

    public double y;

    public double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3() {
        this(0, 0, 0);
    }

    public void add(Vector3 vec3) {
        this.x += vec3.x;
        this.y += vec3.y;
        this.z += vec3.z;
    }

    public void multiply(double multiplier) {
        this.x *= multiplier;
        this.y *= multiplier;
        this.z *= multiplier;
    }

    public Vector3 multiplyCopy(double multiplier) {
        return new Vector3(
            this.x * multiplier,
            this.y * multiplier,
            this.z * multiplier
        );
    }

    public double distance(Vector3 vec3) {
        return Math.sqrt(
            Math.pow(vec3.x - this.x, 2) +
            Math.pow(vec3.y - this.y, 2) +
            Math.pow(vec3.z - this.z, 2)
        );
    }
    
    public double distanceHorizontal(Vector3 vec3) {
        return Math.sqrt(
            Math.pow(vec3.x - this.x, 2) +
            Math.pow(vec3.z - this.z, 2)
        );
    }

    public Vector3 copy() {
        return new Vector3(x, y, z);
    }
    
    @Override
    public String toString() {
        return "Vector3 [x=" + x + ", y=" + y + ", z=" + z + "]";
    }

}
