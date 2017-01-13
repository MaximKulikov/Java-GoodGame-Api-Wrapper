var thisPage = location.origin + location.pathname; // Path to this file
var failurePage = location.origin + "/gg-authorization-failure.html";

var hashValues = {
    access_token: null,
    state: null
};


function extractAccessToken() {
    var hash = document.location.hash;
    var params = hash.slice(1).split("&");
    for (var i = 0; i < params.length; i++) {
        var param = params[i].split("=");
        if (param[0] === "code") {
            hashValues.access_token = param[1]; // access token found
        } else if (param[0] === "state") {
            hashValues.scope = param[1];
        }
    }
}

function getAccessTokenFromHash() {
    extractAccessToken();
    if (hashValues.access_token != null && hashValues.access_token.length > 0) {
        // Send request to server for extraction of access token
        document.location.replace(thisPage + "?code=" + hashValues.access_token + "&state=" + hashValues.scope);
    } else {
        // No access token found
        document.location.replace(failurePage + "?error=access_denied&error_description=no_code_found");
    }
}

function process() {
    if (document.location.search.length > 0) {
        // GET param exists
    } else {
        // Attempt to extract access token from hash
        getAccessTokenFromHash();
    }
}




window.onload = process;