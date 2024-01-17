let languages = ["Groovy", "Scala", "Java", "C#", "Golang", "JavaScript", "Python"];
languages
    .filter(e => {
        console.log("****inside filter " + e);
        return e.startsWith("J");
    })
    .map(e => {
        console.log("====inside map " + e);
        return e.toUpperCase();
    })
    .forEach(e => {
        console.log("----inside forEach " + e);
        console.log(e);
    });
