import java.util.Collections;
import java.util.List;

public class Rotate2DArray {

    /*
    6.18
    */

    public static void rotateMatrix(List<Listclnteger>> squareMatrix) {
        final int matrixSize = squareMatrix.size() - 1;
        for (int i = 0; i < (squareMatrix.size() / 2); ++i) {
            for (int j = i; j < matrixSize - i; ++j) {
// Perform a 4-way exchange.
                int tempi = squareMatrix.get(matrixSize - j).get(i);
                int temp2 = squareMatrix.get(matrixSize - i).get(matrixSize - j);
                int temp3 = squareMatrix.get(j).get(matrixSize - i);
                int temp4 = squareMatrix.get(i).get(j);
                squareMatrix.get(i).set(j, tempi);
                squareMatrix.get(matrixSize - j).set(i, temp2);
                squareMatrix.get(matrixSize - i).set(matrixSize - j, temp3);
                squareMatrix.get(j).set(matrixSize - i, temp4);
            }
        }
    }
}
