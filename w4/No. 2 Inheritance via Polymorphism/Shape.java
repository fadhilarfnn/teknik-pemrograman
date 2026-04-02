    public abstract class Shape {
        private String ShapeName;

        public Shape(String ShapeName){
            this.ShapeName = ShapeName;
        }

        public abstract double area();

        public String toString(){
            return "Shape name: " + ShapeName; 
        }
    }