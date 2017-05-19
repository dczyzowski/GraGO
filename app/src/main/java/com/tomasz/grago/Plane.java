package com.tomasz.grago;

/**
 * Created by Tomasz on 2017-04-10.
 */

public class Plane {

    int dimension;
    Point[][] point_pos;

    //konstrutor domyslny
    Plane(){
        dimension = MainActivity.dimension;
        point_pos = new Point[dimension][dimension];
    }

    // metoda zwracajaca prawde jesli mozna w danym punkcie postawic pionek, jesli nie to falsz
    public boolean putPoint(Point newPoint) {

        if (point_pos[newPoint.getY()][newPoint.getX()] == null) {
            point_pos[newPoint.getY()][newPoint.getX()] = newPoint;
            checkConnection();
            return true;
        }
        return false;
    }

    public void checkConnection() {

        //sprawdzamy polączenia na całej planszy, czy nie zostal okrazony ktorys z punktow
        for (int y = 0; y < dimension; y++) {
            for (int x = 0; x < dimension; x++)


                //jesli istnieje badany punkt, sprawdz czy dookola nniego sa inne punkty
                if(point_pos[y][x] != null) {

                    //oczekuje ze wystapi wyjatek na skrajach planszy
                    try {
                        if (point_pos[y - 1][x] == null || point_pos[y - 1][x].getColor() == point_pos[y][x].color)
                            continue;
                    }catch (ArrayIndexOutOfBoundsException e){

                    }

                    try {
                        if (point_pos[y + 1][x] == null || point_pos[y + 1][x].getColor() == point_pos[y][x].color)
                            continue;
                    }catch (ArrayIndexOutOfBoundsException e){

                    }

                    try {
                        if  (point_pos[y][x + 1] == null || point_pos[y][x + 1].getColor() == point_pos[y][x].color)
                            continue;
                    }catch (ArrayIndexOutOfBoundsException e){

                    }

                    try {
                        if (point_pos[y][x - 1] == null || point_pos[y][x - 1].getColor() == point_pos[y][x].color)
                            continue;
                    }catch (ArrayIndexOutOfBoundsException e){

                    }

                    //odejmuje punkty gdy zniknie jakis pionek
                    if(point_pos[y][x].color == R.drawable.bialy)
                        MainActivity.pointBialy -= 1;
                    else if(point_pos[y][x].color == R.drawable.czarny)
                        MainActivity.pointCzarny -= 1;

                    //w jego miejsce wstawiam puste pole
                    point_pos[y][x].setColor(R.drawable.blank);
                }
        }
    }

    public Point[][]getPoint_pos(){
        return point_pos;
    }
}


