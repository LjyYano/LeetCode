import java.util.Random;

public class L0478_GenerateRandomPointInACircle {
    private double radius;
    private double x_center;
    private double y_center;
    private Random random;
    
    public L0478_GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.random = new Random();
    }
    
    // 方法一：拒绝采样
    public double[] randPoint() {
        while (true) {
            // 在正方形内随机生成点
            double x = random.nextDouble() * 2 * radius - radius;
            double y = random.nextDouble() * 2 * radius - radius;
            
            // 检查是否在圆内
            if (x * x + y * y <= radius * radius) {
                return new double[]{x_center + x, y_center + y};
            }
        }
    }
    
    // 方法二：极坐标法（更优）
    public double[] randPointPolar() {
        // 随机角度
        double theta = random.nextDouble() * 2 * Math.PI;
        // 随机半径（注意要对 r² 均匀采样）
        double r = Math.sqrt(random.nextDouble()) * radius;
        
        // 转换为笛卡尔坐标
        double x = x_center + r * Math.cos(theta);
        double y = y_center + r * Math.sin(theta);
        
        return new double[]{x, y};
    }
} 