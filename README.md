# What is SoSafe Home Security Simulator?

The SoSafe Home Security Simulator is a **Java** desktop application built using the **"Gang of Four" Design Patterns**. It emulates a microprocessor-based security systems for homes and large commercial properties. The system can be installed in a large commercial building to monitor one or more areas in the building. A commercial building can be divided into sections, where each section is divided into rooms.

![sosafe_sec_sys_sim_collage](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/sosafe_sec_sys_sim_collage.png)

# Application Features

The system uses motion sensors, which are placed at specific locations throughout the buildings, to detect break-in’s and set off an alarm to call a monitoring service through a phone- line. Similarly, the system provide temperature sensors for fire detection and calls the monitoring service. There is also a sensor that reacts to the collapse of a senior. SoSafe plans to use this in the future to expand their services to monitor the safety of senior citizens living by themselves.

When a client/customer (building management) buys the services of a security system, the client can choose to include all or some of the sections of the building. Accordingly, the sensors will be installed in those areas.

The system consists of sensors (motion sensors and temperature sensors) located at various places in a building. Each sensor is identified with a number and its location. The system provides a wall-mounted control panel (with a display panel and function keys), using which the customer can configure the system, monitor and change the configuration. For example, the customer can selectively disable or enable specific (or all) sensors.

The system (with security system or fire alarm system or both) can be programmed by the customer to telephone a monitoring agency when a situation is detected.

A master password is programmed for arming and disarming the system. The system can be programmed for arming the fire alarms separately from security alarms. The control panel’s display shows if the system is on, off, malfunctioning and/or if certain specific sensors are inactive.

The system can be activated by turning on the start button or using a timer and a schedule. The system can be configured to set off an alarm if a break-in is detected or a fire is detected or if the system is malfunctioning. Optionally, the system can call a monitoring-service. The call is made to the telephone numbers provided, identifying the time of the call, identification of the service number, location and the nature of the problem. A customer can selectively activate some or all of the sensors, the default case being all the sensors are activated.

# Application Demo

## Account

### New

The account screen is where the client can enter their personal information to setup an account. The contractID, name, phone, email, and emergency contact information can be entered here. New will reset the fields on this page as well as the building that is associated with this account.

![img2_accountDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img2_accountDemo.png)

### Load/Save

Load will load a previously saved account from the client’s machine with the contractID and the client information. Unfortunately, load has not been fully implemented to load building associated with this account.

Save will save the current information to a file on the client’s machine.

![img3_accountDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img3_accountDemo.png)

### Print

Print will generate a printable format of the customer’s information along with the bill associated with this account.

![img4_accountDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img4_accountDemo.png)

## Setup

### New Building

The setup screen is where the client can setup the building which he/she will like to install sensors. It also contains an image of a blueprint of the building which the client has provided to us. On initial load, there are no options other than to add a new building.

![img5_setupDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img5_setupDemo.png)

### Sensor Warning

An option for a sensor (including no sensor) must be selected before a client can continue.

![img6_setupDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img6_setupDemo.png)

### New Section/Room/Sensor

After the initial building/section/room has been created, the client can add a new section, new room, or new sensor to an existing building, section, or room. In this example, a new sensor will be added to an existing building/section/room.

![img7_setupDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img7_setupDemo.png)

## Simulation

### Control Panel

The simulation screen is where the client can view the sensors that are installed and interact with it using the simulated control panel. The control panel contain options to arm sensors, disarm sensors, check status of sensors, schedule sensors to arm, call an emergency number, and to test the sensors.

![img8_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img8_simDemo.png)

### Arm Sensors

Sensors can be armed by pressing ‘Arm’ and selecting the sensors that the client will like to arm.

![img9_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img9_simDemo.png)

The client can press * to cancel or # to confirm their selection.

![img10_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img10_simDemo.png)

### Disarm Sensors

Sensors can be disarmed by pressing ‘Disarm’ and selecting the sensors that the client will like to disarm.

![img11_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img11_simDemo.png)

The client can press * to cancel or # to confirm their selection.

![img12_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img12_simDemo.png)

### Schedule Sensors

The client can schedule sensors to be armed by pressing “Schedule”. First, select the number of seconds for the delay start. Then, select the sensors that should be armed. Press * to cancel at each state or # to confirm.

![img13_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img13_simDemo.png)

![img14_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img14_simDemo.png)

![img15_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img15_simDemo.png)

![img16_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img16_simDemo.png)

### Emergency Call

The client can dial an emergency by pressing “Emergency”. Press * to cancel the call or # to confirm.

![img17_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img17_simDemo.png)

![img18_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img18_simDemo.png)

### Sensor Test

The sensors can be tested by selecting “Test”.

![img19_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img19_simDemo.png)

Select the sensors that should participate in the test.

![img20_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img20_simDemo.png)

The table is updated to show that status has been changed. The client can also press “status” on the control panel to check the status for each group of sensors.

![img21_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img21_simDemo.png)

Press Arm and select sensors to rearm all sensors that were tripped during the test.

![img22_simDemo](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img22_simDemo.png)

# UML Diagram

![img1_classDiagram](https://github.com/hinsenchan/sosafe_security_system_sim/blob/master/readme/img1_classDiagram.png)

# Design Principles

* Single Responsibility Principle
  * Classes are small with 1 responsibility each. For example, the TemperatureSensor class is concerned only with the temperature and not motion.
* OCP(Open Closed Principle)
  * Our code is open for extension and closed for modification. New sensors such as a humidity sensor can later be added without modifying any existing classes.
* Liskov Substitutability Principle
  * Classes can easily be subclassed and implemented without breaking down the system. The temperature, motion, and senior seniors are subclassed from the sensor class.
* Dependency Inversion Principle
  * Designs were built using abstractions, not concretions which makes modifications easy to implement.

# Design Patterns

## Abstract Factory Patterns

### SimPanelAbstractFactory

The SimPanelAbstractFactory provides an interface which creates a family of panels that is used in the SecuritySim. Each panel represents a screen that the SecuritySim application will use to display customer or simulation information for the program.

### SimPanelConcreteFactory

The SimPanelConcreteFactory is the factory instantiation that is used to create the actual panels which will be used in the application. The concrete factory implements the construction of the various panels that is listed in the abstract factory interface. It uses the getInstance() method to retrieve the Singleton instance for each panel.

## Builder Pattern

The builder pattern is used to create the complex objects View, Controller, and Model for our application.The builder pattern separates the construction of these objects from its representation. This allows our construction process to create different representations where we can swap out different view, controllers, and models in the future. It also allows us to set our application to a default starting state required from each component.

### SecuritySimBuilder

The SecuritySimBuilder is used by the SecuritySimDirector to generate a SecuritySim object. This builder contains all the methods that are required to construct the complex SecuritySim object and set it to the correct initial state. The builder provides the interface to allow the director to call the appropriate methods to generate the output of the document. By using a builder, future implementations of the application can use it to change the initial state of the SecuritySim object.

### SecuritySimConcreteBuilder

The SecuritySimConcreteBuilder creates a SecuritySim object using its concrete implementation of the methods specified in the SecuritySimBuilder interface.

### SecuritySimDirector

The SecuritySimDirector uses the SecuritySimBuilder to build the SecuritySim object using the required steps in the correct order. By using a builder pattern, the construction of the complex document object is separated from the construction process. We also preserve OCP and type safety if new directors are subclassed from SecuritySimDirector. By using a SecuritySimDirector, future implementations of SecuritySim can be created without specifying violating OCP or changing data types in their code.

### SecuritySimConcreteDirector

The SecuritySimConcreteDirector can use the concrete builders to generate a SecuritySim object. The SecuritySimConcreteDirector is used when the application starts to generate a SecuritySim with the correct initial states.

### SecuritySimControllerBuilder

The SecuritySimBuilder is used by the SecuritySimControllerDirector to generate a SecuritySimController object. This builder contains all the methods that are required to construct the complex SecuritySimController object and set it to the correct initial state. The builder provides the interface to allow the director to call the appropriate methods to generate the output of the document. By using a builder, future implementations of the application can use it to change the initial state of the SecuritySimController object.

### SecuritySimControllerConcreteBuilder

The SecuritySimControllerConcreteBuilder creates a SecuritySimController object using its concrete implementation of the methods specified in the SecuritySimControllerBuilder interface.

### SecuritySimControllerDirector

The SecuritySimControllerDirector uses the SecuritySimControllerBuilder to build the SecuritySimController object using the required steps in the correct order. By using a builder pattern, the construction of the complex document object is separated from the construction process. We also preserve OCP and type safety if new directors are subclassed from SecuritySimControllerDirector. By using a SecuritySimControllerDirector, future implementations of SecuritySimController can be created without specifying violating OCP or changing data types in their code.

### SecuritySimControllerConcreteDirector

The SecuritySimControllerConcreteDirector can use the concrete builders to generate a SecuritySimController object. The SecuritySimControllerConcreteDirector is used when the application starts to generate a SecuritySimController with the correct initial states.

### SecuritySimModelBuilder

The SecuritySimModelBuilder is used by the SecuritySimModelDirector to generate a SecuritySimModel object. This builder contains all the methods that are required to construct the complex SecuritySimModel object and set it to the correct initial state. The builder provides the interface to allow the director to call the appropriate methods to generate the output of the document. By using a builder, future implementations of the application can use it to change the initial state of the SecuritySimModel object.

### SecuritySimModelConcreteBuilder

The SecuritySimModelConcreteBuilder creates a SecuritySimModel object using its concrete implementation of the methods specified in the SecuritySimModelBuilder interface.

### SecuritySimModelDirector

The SecuritySimModelDirector uses the SecuritySimModelBuilder to build the SecuritySimModel object using the required steps in the correct order. By using a builder pattern, the construction of the complex document object is separated from the construction process. We also preserve OCP and type safety if new directors are subclassed from SecuritySimModelDirector. By using a SecuritySimModelDirector, future implementations of SecuritySimModel can be created without specifying violating OCP or changing data types in their code.

### SecuritySimModelConcreteDirector

The SecuritySimModelConcreteDirector can use the concrete builders to generate a SecuritySimModel object. The SecuritySimModelConcreteDirector is used when the application starts to generate a SecuritySimModel with the correct initial states.

## Iterator Pattern

Room has a sensor list.Iterator which is used to traverse it. Section has a list of rooms.Iterator that is used to traverse it. Building has a Section list Iterator which is used to traverse, add, or remove to the list.

## MVC Pattern

The MVC pattern achieves loose coupling between the 3 major components which are the SecuritySimModel, SecuritySim, and SecuritySimController. The SecuritySim class is the view which handles displaying data to the client. It contains all of the view panels. The SecuritySimController decorates the view using the data from the SecuritySimModel. It is the liaison between the model and the view. The SecuritySimModel contains the business logic for the overall application. It stores all of the information regarding the layout of the building, the sensors that are installed, and the customer information.

## Null Object Pattern

Three types of real sensors are used and a null sensor is provided which does nothing to prevent the need to test for null.

### Null Sensor

This is used for the case when a section of a building or room does not have a sensor installed.

### Security Null Object

Null object pattern is also used for security objects. Three types of security- Break-in, fire security are provided along with NullSecurity to ensure the working of project and to enable testing before providing specific security.

## Observer

### Sensor, Room, Security

The purpose is to define a one-to-many dependency between objects. When one object changes state, all its dependents are notified and updated automatically”. When sensors change state, it is communicated to room. When the room changes state, it is automatically communicated to Security.

## Singleton

A single instance of each component is created. This maintains consistency across references shared between these objects. 

### LogManager

The Log manager uses the singleton pattern. There is a single manager to manage logging of a break in or a fire alarm occurring. As mentioned previously, this maintains consistency since there is only one log manager instance for the entire project.

### SecuritySim

Single instance of SecuritySim is created. This object represents the main simulation program and contains the primary view of the application. Only one instance is needed, because only the controller will be communicating with this object. By using the singleton pattern, it is ensured that the same instance will be used if call to getInstance() is made to this object.

### SecuritySimConcreteBuilder

Single instance of SecuritySimConcreteBuilder is created. This object facilitates the construction of the complex application view object. It separates the individual steps which is required to set the initial state of the SecuritySim object. Only a single instance is needed. By using the singleton pattern for this builder, it is ensured that the same instance will be used across the application to create the controller object.

### SecuritySimConcreteDirector

Single instance of SecuritySimConcreteDirector is created. This object uses a builder object to direct the construction of the complex view object for the application. Only a single instance is needed. By using the singleton pattern, it’s ensured that the same instance is used for this creation process.

### SimBillPanel

Single instance of SimBillPanel is created. This object represents the panel that is used by SecuritySim to display the customer bill. Only one instance is needed, because all changes that pertain to the bill should be made to the same bill panel. By using the singleton pattern, it is ensured that the same instance will be used if call to getInstance() is made to this object.

### SimControlPanel

Single instance of SimControlPanel is created. This object represents the panel that is used by SecuritySim to display the control panel for the simulator. Only one instance is needed, because the simulator only uses one control panel to interact with the user and the business logic in the backend. By using the singleton pattern, it is ensured that the same instance will be used if call to getInstance() is made to this object.

### SimCustomerPanel

Single instance of SimCustomerPanel is created. This object represents the panel that is used by SecuritySim to display the form that requests customer information for the application. Only one instance is needed, because the simulator only uses one customer panel to receive input from the user. By using the singleton pattern, it is ensured that the same instance will be used if call to getInstance() is made to this object.

### SimMapPanel

Single instance of SimMapPanel is created. This object represents the panel that is used by SecuritySim to display the map of the building for the application. Only one instance is needed, because the simulator uses this panel to display a map which is used by the application. In the future, maps can be swapped in and out through the use of a button and file selector. Even with this future implementation, only a single instance of the map panel will be required. By using the singleton pattern, it is ensured that the same instance will be used if call to getInstance() is made to this object.

### SimSensorDisplayPanel

Single instance of SimSensorDisplayPanel is created. This object represents the panel that is used by SecuritySim to display the layout of the building and the sensors that have been installed. Only one instance is needed, because the simulator uses this single panel to display a table which receives its data from the simulation model. Only a single instance of this panel will be required since it is the data in it that will be changed. The panel itself does not require multiple instances in the simulation application. By using the singleton pattern, it is ensured that the same instance will be used if call to getInstance() is made to this object.

### SimSensorSetupPanel

Single instance of SimSensorSetupPanel is created. This object represents the panel that is used by SecuritySim to display the building setup and sensor installation screen. Only one instance is needed, because the simulator uses this single panel to display the input form that requests the relevant setup information from the customer. Only a single instance of this panel will be required, since any information captured from this panel should be forwarded to the model for the same customer. The panel itself does not require multiple instances in the simulation application. By using the singleton pattern, it is ensured that the same instance will be used if call to getInstance() is made to this object.

### SimPanelConcreteFactory

Single instance of SimPanelConcreteFactory is created. This object represents the abstract factory that is used by SecuritySim to create all of the display panels that are used the application. Only a single instance of this factory is needed since there is no intrinsic state that will be stored in the factory. By using a singleton for the factory, it saves resources and keeps the code short and concise.

### SecuritySimController

Single instance of SecuritySimController is created. This object represents the main simulation program’s controller. It has a reference to the view and the model. Only one instance of this object is needed, because any calls to the application controller should be directed to the same instance. By using the singleton pattern, it is ensured that the same instance will be used across the application.

### SecuritySimControllerConcreteBuilder

Single instance of SecuritySimControllerConcreteBuilder is created. This object facilitates the construction of the complex application controller object. It separates the individual steps which is required to set the initial state of the SecuritySimController object. Only a single instance is needed. By using the singleton pattern for this builder, it is ensured that the same instance will be used across the application to create the controller object.

### SecuritySimControllerConcreteDirector

Single instance of SecuritySimControllerConcreteDirector is created. This object uses a builder object to direct the construction of the complex controller object for the application. Only a single instance is needed. By using the singleton pattern, it’s ensured that the same instance is used for this creation process.

### SecuritySimModel

Single instance of SecuritySimModel is created. This object represents the main simulation program’s model. It has a reference to the controller. Only one instance of this object is needed, because any calls to the application model should be directed to the same instance. By using the singleton pattern, it is ensured that the same instance will be used across the application.

### SecuritySimModelConcreteBuilder

Single instance of SecuritySimModelConcreteBuilder is created. This object facilitates the construction of the complex application model object. It separates the individual steps which is required to set the initial state of the SecuritySimModel object. Only a single instance is needed. By using the singleton pattern for this builder, it is ensured that the same instance will be used across the application to create the controller object.

### SecuritySimModelConcreteDirector

Single instance of SecuritySimModelConcreteDirector is created. This object uses a builder object to direct the construction of the complex model object for the application. Only a single instance is needed. By using the singleton pattern, it’s ensured that the same instance is used for this creation process.

### Simulator

Single instance of simulator is created. This object represents the main application’s simulator program. It is used by the application to control the business logic for the simulator. All of the user inputs and simulator outputs to the ControlPanel should be fed through a single instance of the simulator. By using the singleton pattern, it is ensured that the same instance will be used across the application.

## State Pattern

The state pattern is used to enable a hierarchy to be established that allows the simulator to transition between its sub-program states. Each major function on the control panel has its own state definition. When a function is selected, the simulator transitions to that state and handles it routine.

### Simulator (Context)

The Simulator is the context which is used in the State Pattern to define the interface of interest to the clients. In this case, it is the action buttons on the control panel: arm, disarm, status, schedule, emergency, and test. The context also maintains the instance of the concreteState subclass that defines the current state. These are the various actions that the client can select to interact with the control panel simulator. The context describes all of the basic behaviors that the simulator has and which state currently has control.

### SimulatorState (State)

The SimulatorState is the interface that encapsulates the simulator’s behavior which is associated with the various states of the context: arm, disarm, status, schedule, emergency, test. A simulator has four main behaviors. It can run a function. It can confirm or cancel an action. It can also accept input.

### SimulatorArmState (ConcreteState)

The SimulatorArmState is a concreteState which implements a behavior described by the SimulatorState interface (State). The SimulatorArmState arms all of the sensors or a particular set of sensors selected by the client. After it executes its main function, it will return the context back to the default state.


### SimulatorDisarmState (ConcreteState)

The SimulatorDisarmState is a concreteState which implements a behavior described by the SimulatorState interface (State). The SimulatorDisarmState disarms all of the sensors or a particular set of sensors selected by the client. After it executes its main function, it will return the context back to the default state.

### SimulatorEmergencyState (ConcreteState)

The SimulatorEmergencyState is a concreteState which implements a behavior described by the SimulatorState interface (State). The SimulatorEmergencyState dials the emergency contact number. After it executes its main function, it will return the context back to the default state.

### SimulatorScheduleState (ConcreteState)

The SimulatorScheduleState is a concreteState which implements a behavior described by the SimulatorState interface (State). The SimulatorScheduleState schedules sensors selected by the client to be armed. After it executes its main function, it will return the context back to the default state.

### SimulatorStandbyState (ConcreteState)

The SimulatorStandbyState is a concreteState which implements a behavior described by the SimulatorState interface (State). The SimulatorStandbyState is the default state of the context.

### SimulatorStatusState (ConcreteState)

The SimulatorStatusState is a concreteState which implements a behavior described by the SimulatorState interface (State). The SimulatorStatusState checks the list of sensors that is installed in the building and display its status to the client on the control panel. After it executes its main function, it will return the context back to the default state.

### SimulatorTestState (ConcreteState)

The SimulatorTestState is a concreteState which implements a behavior described by the SimulatorState interface (State). The SimulatorTestState trips all of the sensors that have been installed in the building. After it executes its main function, it will return the context back to the default state.

# References

* [JavaTM Platform, Standard Edition 8 API Specification](http://docs.oracle.com/javase/8/docs/api/)
* [Java Package javax.swing](http://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)
* [Astah UML Editor](http://astah.net/)

# Credits

This software was developed by Hinsen Chan and Nidhi Singh at Santa Clara University in Summer 2014.