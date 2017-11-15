function addToCart(URL,article) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL+article, true);
    xhttp.send(article);
}

function deleteFromCart(URL,data) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);
    xhttp.send(data);
    window.location.reload();
}



