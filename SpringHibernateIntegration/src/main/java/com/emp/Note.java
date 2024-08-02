package com.emp;

public class Note {

	
	/*
	
	 1) You need to create a sequence in your Oracle database.
	 2) 
	 @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence_generator")
     @SequenceGenerator(name = "my_sequence_generator", sequenceName = "my_sequence", allocationSize = 10)
     private Long id;
	 
	 @SequenceGenerator is used to define the sequence generator with the name "my_sequence_generator", linked to the Oracle sequence "my_sequence".
	 
	 
	 
	 JPA (with Hibernate as the JPA provider) internally calls the nextval() method on the sequence to generate the next primary key value.
	 When you call repository.save(entity), Hibernate executes a query to get the next sequence value. SELECT my_sequence.NEXTVAL FROM DUAL;
	 
	 Uses the returned value as the primary key for the new entity.
	 Executes the INSERT statement to persist the entity with the generated primary key.
	 
	 
	 
	 Sequences can optimize performance in Hibernate (or any ORM) by reducing the number of database round-trips required to fetch new primary key values. 
	 This is achieved through the allocationSize parameter in the @SequenceGenerator annotation.
	 
	 Allocation Size: This parameter defines the number of sequence values Hibernate will fetch at once.
	 Optimizer Strategies: Hibernate can use different optimization strategies based on the allocationSize.
	 
	 In above sequence
	 Initial Fetch: When Hibernate needs a new primary key for the first time, it will fetch 10 values from the sequence in one query.
	 SELECT my_sequence.NEXTVAL FROM DUAL CONNECT BY LEVEL <= 10;
	 This might result in something like: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		
	 In-Memory Management: Hibernate keeps these values in memory and assigns them to new entities without making another database call. 
	 So, for the next 9 entities, Hibernate will use the cached sequence values.
	 Next Fetch: Once all 10 values are used, Hibernate will make another call to fetch the next block of 10 values
	 
	 
	 
	 
	 
	*/
	
}
