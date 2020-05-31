ASSIGNMENT: CAR, PARKING PERMIT, PARKING TRANSACTION, PARKING OFFICE CLASSES
===============================================================================

PURPOSE OF ASSIGNMENT
-------------------------

The University has a need to develop an Object-Oriented Parking System. Each assignment will build towards creating the parking system for your portfolio.

* The University has several parking lots and the parking fees are different for each parking lot.
* Customers must have registered with the University parking office in order to use any parking lot. Customers can use any parking lot. Each parking transaction will incur a charge to their account.
* Customers can have more than one car, and so they may request more than one parking permit for each car.
* The University provides a 20% discount to compact cars compare to SUV cars.
* For simplicity, assume that the Parking Office sends a monthly bill to customer and customer pays it outside of the parking system.
* Each week you will need to submit an updated Class Diagram along with the other deliverables for the assignment.

In this assignment we shall demonstrate the use of **loosely coupled classes** and **appropriate levels of abstraction**.

ASSIGNMENT INSTRUCTIONS
---------------------------

Develop Java code for the below classes. The data attributes and methods are provided as a guide, please feel free to add more as you feel necessary. Explain your choices in the write-up. 

.. important::

    Note that the ``Car``, ``ParkingPermit`` and ``ParkingTransaction`` classes should be **immutable**; once created with values they cannot be modified.

.. rubric:: Class: Car

* Data Attributes
    * type : CarType
    * licensePlate : String
    * Owner : Customer

* Behaviors
    * getType() : CarType
    * getLicensePlate() : String
    * getOwner() : Customer

.. rubric:: Class: ParkingPermit

* Data Attributes
    * id : String
    * car : Car
    * expiration : Date

* Behaviors
    * getCar() : Car

.. rubric:: Class: PermitManager 

* Data Attributes
    * permits : List<ParkingPermit>
    * Behaviors
    * register(Car) : ParkingPermit

.. rubric:: Class: ParkingTransaction 

* Data Attributes
    * date : Date
    * permit : ParkingPermit
    * parkingLot : ParkingLot
    * chargedAmount : Money

* Behaviors
    * getChargedAmount() : Money
    * getPermit() : ParkingPermit

.. rubric:: Class: TransactionManager 

* Data Attributes
    * transactions : List<ParkingTransaction>

* Behaviors
    * park(Date, ParkingPermit, ParkingLot) : ParkingTransaction
    * getParkingCharges(ParkingPermit) : Money
    * getParkingCharges(Customer) : Money

Create a 500-word write-up that explains your assignment. You may address some of the below questions.

* What did you find difficult or easy?
* What helped you?
* What you wish you knew before?
* Outline any implementation decisions and the reasoning behind those.
* Include screenshots of the successful code compilation and test execution.
* Submit a zip file that includes 
    * **Class diagrams**
    * **write-up**
    * **Source java files**
    * **Unit Test java files**

* In your write-up include **screenshots of successful unit tests**.
