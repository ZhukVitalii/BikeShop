
document.getElementsByClassName('numbers').onkeypress = function (e) {
    return !(/[А-Яа-яA-Za-z ]/.test(String.fromCharCode(e.charCode)));
}
