# android-dagger
Dependency Injection :- 
 
Dependency injection is a technique whereby one object supplies the dependencies of another object.
Let us segregate the dependency injection into dependency and injection

A "dependency" is an object that can be used, for example a service. Instead of a client specifying which service it will use, something tells the client what service to use. The "injection" refers to the passing of a dependency (a service) into the object (a client) that would use it.

It is an act of injecting services to the client from outside i.e receiving dependencies from outside.

Techniques of Dependency Injection
   
   a. Constructor Injection
   b. Method Injection
   c. Field Injection.
   
Constructor Injection is the best way of injecting services to client as constructor signature reflects all the dependency, dependencies can be made final, it is simple and readable, easy to test client by mocking services.

Method Injection is way of receiving dependencies as parameter in method declaration. The advantage is that someone can pass the dependency(service) to the client even after client's construction. This may lead to temporal coupling i.e. method should be called in a particular order which may create chaos in large projects. 

Field Injection is the way of assigning dependencies directly to the fields which can be accessed by some object. It makes code hard to read and understand, rest all cons are equivalent to method injection.

Therefore, Always use contructor injection unless,
 Service instance can only be created after the client's instantiation or if there is any limitation imposed by the framework.
   
