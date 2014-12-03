function navbar() {
}

navbar.prototype.activateMenu = function (page) {
    if (/^#/.test(page) || /^./.test(page)) {
        $(page).addClass("active");
    }
}