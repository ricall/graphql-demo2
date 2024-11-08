# graphql-demo

A simple spring boot application for working with a simple graphql api

## Getting started [start here]

To run the application
```bash
./gradlew bootRun
```

This will start a graphQL server on `http://localhost:8080/graphql`

You can use the `graphiql` interface for testing the API: `http://localhost:8080/graphiql`

### Variables
```json
{
  "tutorialId": "23941c13-ba27-45b8-82ca-707c1d844efe",
  "authorId": "b7512e5d-725c-4d52-80f5-39e82e0a39d6"
}
```

### Queries

```graphql
query RunAllQueries($tutorialId: ID!, $authorId: ID!) {
  tutorials {
    id
    title
    description
    author {
      id
      name
      age
    }
  }
  authors {
    id
    name
    age
  }
  tutorialById(id: $tutorialId) {
    title
  }
  authorById(id: $authorId) {
    name
  }
}
```

### Mutations
```graphql
mutation RunAllMutations($authorId: ID!, $tutorialId: ID!) {
  deleteAuthor(id: $authorId) {
   id
   name
  }
  saveAuthor(name: "test author", age: 31) {
    id
    name
  }
  deleteTutorial(id: $tutorialId) {
    id
    title
  }
  saveTutorial(title: "new tutorial", description: "user created tutorial", authorId: "test author") {
    id
  }
}
```