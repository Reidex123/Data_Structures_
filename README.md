# DATA STRUCTURES
 - A collection of data structure implemented in java.

## Table of Contents
- [DATA STRUCTURES](#data-structures)
  - [Table of Contents](#table-of-contents)
  - [Requirements](#requirements)
  - [Installation and Setup](#installation-and-setup)
    - [Clone the repository](#clone-the-repository)
  - [Features](#features)
  - [Contributing](#contributing)
  - [License](#license)

## Requirements
 - Java: ``JDK 21+``
 - Build Tool: ``Maven 3.9+``

## Installation and Setup
   ### Clone the repository
- SSH:
    ```bash
    git clone git@github.com:Reidex123/Data_Structures_.git
    ```
- HTTPS:
    ```bash
    git clone https://github.com/Reidex123/Data_Structures_.git
    ```
    ### How to install maven
    - [click here](https://dlcdn.apache.org/maven/maven-3/3.9.12/binaries/apache-maven-3.9.12-bin.zip)
    - Unzip it to a folder, named: ``C:\Program Files\Apache\Maven``

    #### Set Environment Variables

    - Search for Environment Variables → Edit system environment variables → Environment Variables.

    - Under System Variables, click ``New``:

    - Variable name: ``MAVEN_HOME``

    - Variable value: ``C:\Program Files\Apache\Maven\apache-maven-3.9.4``

    - Edit the Path variable → Add: ``%MAVEN_HOME%\bin``
    - verify installation: ``mvn  -v``

    ### build with maven
    ```bash
    ./run
    ```

## Features
 - Generic Support: Each and every data structure will be generic.
 - Trees supports:
   - Breadth-First Search: ``LevelOrder()``
   - Depth-First-Search: ``PreOrder() ``, ``InOrder()``, ``PostOrder()``
   - Utility Methods: ``size()``, ``height()``
   - Main operations: ``insert()``, ``remove()``, ``contains()``
 - Testing:
   - testing during **push** and **pull request**
 - LinkedLists supports:
   - add, remove, addFirst, addLast, peek, peekFirst, peekLast
   - Traversal over the list

## Contributing
    ...

## License
    MIT License
