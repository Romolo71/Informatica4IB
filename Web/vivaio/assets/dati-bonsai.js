fetch("http://192.168.4.59:8000/listaPersone").then(
    response => response.json()
    ).then((data) => {
        data.forEach(element => {
            console.log(element.nome);
            // console.log(`${element.nome}`); // in alternativa
            }   
        );
    }).catch(error => console.log("Si è verificato un errore!")
)