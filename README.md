OO Systems development project - ING2 Software Engineering<br>
BOU FERRAA Karel & SAKHO Mohamed

this project aims to create a REST api which partially replicate the functionality found on the website tagger.scryfall.com<br>
That is, create card taggings, make a tag a parent of another tag, modify the parents / children of tags, delete a tag.

Each tag can be the parent of many tags and can be the child of many tags.

# Architecture

The important code is in `src/main/java/org/tagger`. Relative to that directory:<br>
`controllers` holds the code responsible for mapping each api path to a method<br>
`services` provides many useful methods on entities such as searching, deleting tags, adding tags as children ect...
	- The interface definition (`TagService.java`) is separated from it's implementation (`TagServiceImpl.java`)<br>
`entities` defines the base classes of the application.
	- Tag is the base class
	- we define the primary key of Tag in a separate file TagKey because it is a composite key so we need to define a class for it. We do not want to just use an id for the primary key because we want the combination of a tag type and a tag name to be unique.
	- the exceptions directory holds all the custom exception classes
	- because of the recursive structure of tags, we had to implement a custom JSON serializer to avoid a recursive error when trying to return the card taggings. Indeed, if tag A has parent B, parent B contains tag A as it's children. This is the purpose of the TagJSONSerializer

# Testing

cd in the top of the projects directory and run the following command to start the server
```bash
./gradlew bootRun
```
Then naviguate to localhost:8080 in your browser

Some test curl requests can be found in the directory `testscripts/`
