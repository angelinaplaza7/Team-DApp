# Architecture

**Project Overview:**
Team-DApp is focused on developing an application that will not only show pictures of dogs to the user, it will accept feedback on each of these dogs and after enough data is collected the application itself will be able to determine the preference of each user. Once the preferences of each user are determined it will look for pictures that will cater those preferences.

**Key Architectural Drivers:**
The language used for programming is Java.
The application will only be available in one operating system which is android. 
The use of Firebase as the database was required to collect the user’s information and to keep track of everything that the user selected. Communication between the database and the application is crucial.

**Architectural Style Choices**
The two architecture styles that the team determined to be the best are:
Space Based Architecture,
Event Driven Architecture 

**Space Based Architecture:** 
Space Based Architecture is useful to avoid functional collapse under high loads, this is done by splitting up the processing and storage of data. Sometimes it is called the cloud architecture. This is a good architecture for high volume click streams and user logs.

**Event Driven Architecture:**
Space-based architecture is useful when the application needs user input and it  helps managing all processes by making a central unit that will receive all the data and delegate the data according to the module that the certain data types belong to.

**Decision**
After some analysis of both architectures the team determined that the best fit for the application is Space Based because it is better for high volume user clicks and high volume user logs.  Which will be used for determining the preferences of the user.

**Conclusion**
The architecture style that will be used is Space base architecture it makes easier to collect high amounts of data and have other computations in the same program without significantly reducing the speed of the application
