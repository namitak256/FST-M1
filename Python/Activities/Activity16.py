class car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer=manufacturer
        self.model=model
        self.make=make
        self.transmission=transmission
        self.color=color
    def accelerate(self):
        print(self.manufacturer+ self.model+ "is moving")
    def stop(self):
        print(self.manufacturer+ self.model+ "has stopped")

c1=car("Tata", "Nano", "2014", "Petrol", "Navy")
c1.accelerate()
c1.stop()