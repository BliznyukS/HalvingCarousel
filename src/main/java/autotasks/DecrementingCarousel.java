package autotasks;

public class DecrementingCarousel extends CarouselRun {
    private CarouselRun carouselRun;
    private boolean isRunning;
    private int capacity;

    public DecrementingCarousel(int capacity) {
        this.isRunning = false;
        this.capacity = capacity;
        this.carouselRun = new CarouselRun();
    }


    public boolean addElement(int element) {
        if (isRunning) {
            return false;
        }

        if (element > 0 && capacity > 0) {
            carouselRun.setAmountOfNotZeroElements(carouselRun.getAmountOfNotZeroElements() + 1);
            carouselRun.getCarusel().add(element);
            capacity = capacity - 1;
            return true;
        } else {
            return false;
        }
    }

    public CarouselRun run() {
        if (isRunning) {
            return null;
        } else {
            isRunning = true;
            return carouselRun;
        }
    }
}
