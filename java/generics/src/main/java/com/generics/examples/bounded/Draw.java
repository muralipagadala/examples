package com.generics.examples.bounded;

public class Draw<T extends Shape & Drawable> {
        private T shape;

        public Draw(T shape){
                this.shape = shape;
        }

        public void doDraw(){
                shape.draw();
        }

}