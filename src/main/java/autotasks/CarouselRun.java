package autotasks;

import java.util.LinkedList;

public class CarouselRun {

    private int amountOfNotZeroElements; //could be atomicInt
    private LinkedList<Integer> carusel;
    private int decrementPosition;

    public int getAmountOfNotZeroElements() {
        return amountOfNotZeroElements;
    }

    public void setAmountOfNotZeroElements(int amountOfNotZeroElements) {
        this.amountOfNotZeroElements = amountOfNotZeroElements;
        this.decrementPosition = 0;
    }

    public LinkedList<Integer> getCarusel() {
        return carusel;
    }

    public CarouselRun() {
        this.carusel = new LinkedList();
    }

    public int next() {
        if (carusel.isEmpty() || amountOfNotZeroElements == 0) {
            return -1;
        }

        int currentValue = carusel.get(this.decrementPosition);
        int newValue = currentValue - 1;
        carusel.set(decrementPosition, newValue);

        if (newValue == 0) {
            this.amountOfNotZeroElements--;
        }

        this.decrementPosition = calculateNewDecrementPosition(this.decrementPosition);

        return currentValue;
    }

    public int calculateNewDecrementPosition(int currentDecrementPosition) {

        if (amountOfNotZeroElements == 0) {
            return 0;
        }

        int newDecrementPosition = 0;

        if ((carusel.size() - 1) == currentDecrementPosition) {
            newDecrementPosition = 0;
        } else {
            newDecrementPosition = currentDecrementPosition + 1;
        }

        if (carusel.get(newDecrementPosition) == 0) {
            newDecrementPosition = calculateNewDecrementPosition(newDecrementPosition);
        }

        return newDecrementPosition;
    }

    public boolean isFinished() {
        if (amountOfNotZeroElements > 0) {
            return false;
        } else {
            return true;
        }
    }

}
