package autotasks;

public class HalvingCarousel extends DecrementingCarousel {
    private boolean isRunning;
    private int capacity;
    private HalvingCarousel carouselRun;


    public HalvingCarousel(int capacity) {
        super(capacity);
        this.isRunning = false;
        this.capacity = capacity;
        this.carouselRun = new HalvingCarousel(capacity);
    }

    @Override
    public CarouselRun run() {
        if (isRunning) {
            return null;
        } else {
            isRunning = true;
            return carouselRun;
        }
    }

}
