MovieRepository (Repository Layer)
The MovieRepository is a Spring Data JPA repository that extends JpaRepository. It provides CRUD operations for the Movie entity without requiring boilerplate code. It enables interaction with the movies table in the database. You can also define custom queries in this interface if needed.

MovieService (Service Layer)
The MovieService contains the business logic for managing Movie entities. It uses the MovieRepository to perform CRUD operations and exposes methods to the MovieController. The service methods include saving or updating movies, retrieving all movies or a movie by ID, and deleting a movie. The service layer ensures that any additional business rules can be applied without cluttering the controller.

MovieController (Controller Layer)
The MovieController is a REST controller that exposes API endpoints for interacting with Movie entities. It provides endpoints to retrieve all movies, get a movie by its ID, add a new movie, and delete a movie by its ID. The controller acts as a bridge between the client (frontend or API consumer) and the service layer, handling incoming HTTP requests and returning the appropriate responses.
