# Chamber Particle Animation

The project is to animate the movement of particles in the chamber and the result is to evaluate the particles' locations at each moment.

## Getting Started

These instructions will show how to run the program on your local machine for development and testing purposes. 

### Prerequisites

Install Java 1.8 or above

Install Gradle


## Build the project
```
gradlew build
```

## Running the tests
```
gradlew test
```
## Running the application
```
gradlew bootRun
```

# REST API: '/animate'
The application would provide an API called '/animate'.  The expected HTTP request parameter would be in JSON format and the HTTP response would be also in JSON format.

The API requires 2 input parameters: 
	
	speed - the speed is the number of positions each particle moves in one time unit. 
	
	init - initial conditions by a String init containing at each position an 'L' for a leftward moving particle, an 'R' for a rightward moving particle, or a '.' for an empty location

## Sample JSON Format
```
{ "speed": 2, 
  "init": "LR..RL" 
  }
```
## Testing using curl
Test the response of the API using curl

```
curl -X GET "http://localhost:8080/animate" -H "Content-Type: application/json" -d "{ \"speed\": 2, \"init\": \"LR..RL\" }"

```





