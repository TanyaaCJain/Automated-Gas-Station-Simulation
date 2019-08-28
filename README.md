# Automated-Gas-Station-Simulation

[![HitCount](http://hits.dwyl.io/tanyaacjain/Automated-Gas-Station-Simulation.svg)](http://hits.dwyl.io/tanyaacjain/Automated-Gas-Station-Simulation)

To run the simulation, one must run the following commands on the terminal once in the directory tanyapetrolpump.

#### To compile
`javac tanyapetrolpump/TanyaPetrolPump.java`

#### To run
`java tanyapetrolpump.TanyaPetrolPump` 

## File System

**File Name** | **Description**
------------|--------------
[**Assignment Specification.md**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/Assignment%20Specification.pdf) | It gives the specifications assigned for the assignment.
[**Application Guide.md**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/App%20Guide.pdf) | It gives a synopsis of what the application does and how it functions.
[**src**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/tree/master/src) | Directory containing the source files for the application
[src/**tanyapetrolpump/**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/tree/master/src/tanyapetrolpump) | Directory containing the source files for the **tanyapetrolpump** application
[src/tanyapetrolpump/**TanyaPetrolPump.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/TanyaPetrolPump.java) | The main java file that creates timers to periodically generate vehicles to queue, check the queue to send vehicles to available pumps and draw UI simultaneously. The class [**TanyaPetrolPump.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/TanyaPetrolPump.java) is the main class of the gas station simulation.
[src/tanyapetrolpump/**Config.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/Config.java) | The java file containing the initialized and declared global variables with fixed values for the application.
[src/tanyapetrolpump/**Data.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/Data.java) | The java file containing the data for the main program that sets the environment for the gas station simulation. Array lists are initialized and declared for vehicles entering the gas station to queue in line, get fuelled and then get listed in the fuelled vehicles and for performing transaction to generate a transaction list.
[src/tanyapetrolpump/**Pump.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/Pump.java) | This java file simulates a pumps functionality at gas station, which are, to fuel vehicles, note the pump's usage and generate transaction for the vehicle fuelled.
[src/tanyapetrolpump/**GUI**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/tree/master/src/tanyapetrolpump/GUI) | Directory containing the files that draw the terminal or console based UI for the application
[src/tanyapetrolpump/GUI/**MainWindow.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/GUI/MainWindow.java) | The Java file that creates the main window for the GUI and draws on it the gas station simulation and also displays the values of lists defined in [__Data.java__](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/Data.java) and value of global variables defined in [__Config.java__](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/Config.java).
[src/tanyapetrolpump/**models**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/tree/master/src/tanyapetrolpump/models) | Directory containing the definition of main modules that help in the simulation of gas station.
[src/tanyapetrolpump/models/**FuelType**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/tree/master/src/tanyapetrolpump/models/FuelType) | Directory containing definition of the various fuel types of vehicles that arrive at the gas station.
[src/tanyapetrolpump/models/FuelType/**FuelType.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/models/FuelType/FuelType.java) | The java file needed as a template for extension by the different fuel types
[src/tanyapetrolpump/models/FuelType/**Diesel.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/models/FuelType/Diesel.java) | The java type defining the Diesel type of fuel.
[src/tanyapetrolpump/models/FuelType/**LPG.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/models/FuelType/LPG.java) | The java type defining the LPG type of fuel.
[src/tanyapetrolpump/models/FuelType/**Unleaded.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/models/FuelType/Unleaded.java) | The java type defining the Unleaded type of fuel.
[src/tanyapetrolpump/models/**Transaction**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/tree/master/src/tanyapetrolpump/models/Transaction) | Directory containing definition of the transaction generated  of vehicles that have been fuelled at the gas station.
[src/tanyapetrolpump/models/Transaction/**Transaction.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/models/Transaction/Transaction.java) | The java file that generates transaction of vehicles that have been fuelled at the gas station.
[src/tanyapetrolpump/models/**Vehicle**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/tree/master/src/tanyapetrolpump/models/Vehicle) | Directory containing definition of the various vehicles that arrive at the gas station.
[src/tanyapetrolpump/models/Vehicle/**Vehicle.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/models/Vehicle/Vehicle.java) | The java file needed as a template for extension by the different vehicle types
[src/tanyapetrolpump/models/Vehicle/**Car.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/models/Vehicle/Car.java) | The java type defining the Car type of vehicle.
[src/tanyapetrolpump/models/Vehicle/**HGV.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/models/Vehicle/HGV.java) | The java type defining the HGV type of vehicle.
[src/tanyapetrolpump/models/Vehicle/**Van.java**](https://github.com/TanyaaCJain/Automated-Gas-Station-Simulation/blob/master/src/tanyapetrolpump/models/Vehicle/Van.java) | The java type defining the Van type of vehicle.
