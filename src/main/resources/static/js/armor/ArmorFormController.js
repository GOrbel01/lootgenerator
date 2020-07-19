let statCount = 0;

const ST_PREFIX = "sv";

function setupJs() {
    $("#uqCbRow").append("<span id='unqNam'>   Unique Name<span/>");
}

function addStatRow() {
    $("#" + ST_PREFIX + statCount).removeAttr("hidden");
    statCount++;
}

function removeLastStatRow() {
    statCount--;
    $("#" + ST_PREFIX + statCount).attr("hidden",true);
}

function handleUqNameCb() {
    let cbVal = $("#uqCb").is(":checked");
    if (cbVal) {
        $("#genNam").remove();
        $("#uqCbRow").append("<span id='unqNam'>   Unique Name<span/>");
        $("#unqNameRow").removeAttr("hidden");
    } else {
        $("#unqNam").remove();
        $("#uqCbRow").append("<span id='genNam'>   Generated Name<span/>");
        $("#unqNameRow").attr("hidden", true);
    }
}