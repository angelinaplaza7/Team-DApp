# Requirements Specification for Team-DApp

# 1. Introduction
Team DApp will create an application that will show the user pictures of different types of dogs which the user can like or dislike, after a certain amount of pictures have been classified the application will identify user preferences and start recomending pictures that are within the margin of the users preferences.

# 1.1 Purpose of Product
Team-DApp will create an application that will identify the users’ preferences of the types of dogs. By keeping track of the race of dogs that the user likes also tracking the characteristics of those types of dogs. This will also help the user determine which dogs are from his preferences.

# 1.2 Scope of Product
The scope of the product is to be able to use Android Studio to create an application that will show the user different pictures of dogs and it will automatically identify the user's preference. Once enough data is collected with the help of a decision tree the preferences will be found. 

# 1.3 Acronyms, Abbreviations, Definitions
The terms that will be useful to know are:
- Android Studio which is the software that the team will use to develop the application.
- Decision Tree is a predicting model of tree that is commonly used in data mining. 


# 1.4 References
- Android Studio.
- https://developer.android.com/studio
- Decision Tree
- https://en.wikipedia.org/wiki/Decision_tree_learning?fbclid=IwAR04cJya1-r6rvXyRHRy73HLQ3kb50hdFftuBb2wFAGbNKpk59z2HS-BRZQ

# 2. General Description of Product
The product is a software that will be used to automatically control a drone. The goal of the software is to get a drone to travel from point a to point b autonomously and back. Once the drone reaches point b it will gather information of its surroundings to help the user determine something specific about the location, for example if there is a lot of contamination in that area, if the structure is still structurally stable, or to deliver an object to said location. The primarily focus of this product will be to make it easier for users to get a drone to travel to different locations since flying a drone requires a considerable amount of time and attention.

# 2.1 Context of Product
This product is meant to be used whenever a person wants to look at pictures of dogs or if the person wants to identify what characteristics he likes the most in a potential pet. 

# 2.2 Domain Model with Description
Display and describe your domain model.
The team is planning on using an object model (UML) because with this we will be able to complete partial views of the structured model of the system before finishing it. This will be essential because it can provide an outline of how the structure of the software must be to be compliant with the requirements established by the group.

# 2.3 Product Functions (general)
Some of the product functions are that the application itself will be able to identify the preference after each individual user completes the training data required for the application to determine some margins of preference, which then will be used to recommend types of dogs to each user. Also, it will search on the internet to find available dogs for adoption in shelters that fit into the margin of preferences.

# 2.4 User Characteristics and Expectations
Describe your users and their abilities.
The target user for this application is any person who has an interest in dogs, and wants to figure out which types of dogs the user prefers. The only thing that the user must do is like or dislike images of dogs, and the user must also have a smartphone. The rest will be done by the application autonomously.

# 2.5 Constraints
Some constraints that this application could have is that there might not be enough data on the users phone to contain the data of his decisions, also the phone processor might not be able to run efficiently the application, meaning that all the process' must be done efficiently to avoid crashing or to avoid the application not working.

# 2.6 Assumptions and Dependencies
A assumpion is that the user will have a fast enough processor and enough memory to run the application. A dependency that the team has identified is that the user must complete the minimum of the training data requiered to be able to start identifying the preferences.

# 3. Functional Requirements

- The application opens.
- The like button works.
- The dislike button works.
- The image is displayed. 
- The images changes once a button is pressed.
- The decision is stored.(Future Work)
- The preference is calculated.(Future Work)
- The application recommends dogs.(Future Work)
 
# 4. System and Non-functional Requirements
# 4.1 External Interface Requirements (User,Hardware,Software,Communications)
Some software constraints are that the user must have android operating system on the phone that will be used for the application. The interface requirements are that the user can properly see the button and the images that will be displayed on the application. Also, the application will be use firebase as the database for the application.

# 4.2 Performance Requirements
Our application needs to have the performance to be a friendly user interface because this will open the possibility for more people to use the app easily. Also it will require having extra features such as the size and weight, health, age and name of the dog. An app that permits people to start an adoption dog process through the phone via an application will make it simpler for the people then having to go to a dog center of adoptation.

# 4.3 Design Constraints
Some design constraints are that the application will be only available on android devices and not on any other operating system. Some other constraints could be when trying to use the application on a tablet since it might not be optimized for those devices.


# 4.4 Quality Requirements
Users will expect to have an application that will show pictures of dogs to the user without much wait time and when it is processing the preferences the user should not have to wait for long periods of time to receive recommendations. Also the information collected from each user should remain private and should not merge with any information from another user.

# 5. Appendices
- Link to download the android version version we need for the project. https://developer.android.com/studio
 
