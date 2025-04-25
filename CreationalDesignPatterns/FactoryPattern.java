class Main{
    interface Shape{
        void draw();
    }
    
    static class Circle implements Shape{
        @Override
        public void draw(){
            System.out.println("Drawing a circle...");
        }
    }
    
    static class Rectangle implements Shape{
        @Override
        public void draw(){
            System.out.println("Drawing a rectangle...");
        }
    }
    
    static class Triangle implements Shape{
        @Override
        public void draw(){
            System.out.println("Drawing a Triangle...");
        }
    }
    
    static class FactoryPattern{
        public Shape getShape(String type){
            if(type.equalsIgnoreCase("circle")){
                return new Circle();
            } else if(type.equalsIgnoreCase("rectangle")){
                return new Rectangle();
            } else if(type.equalsIgnoreCase("triangle")){
                return new Triangle();
            } else {
                return null;
            }
        }
    }
    
    
    public static void main(String[] args){
        FactoryPattern f = new FactoryPattern();
        
        Shape c = f.getShape("circle");
        c.draw();
        
        Shape r = f.getShape("rectangle");
        r.draw();
        
        Shape t = f.getShape("triangle");
        t.draw();
    }
}
