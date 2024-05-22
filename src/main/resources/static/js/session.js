const sessionId = sessionStorage.getItem('sessionId');

if (!sessionId) {
    window.location.href = "/pages/login.html";
}
