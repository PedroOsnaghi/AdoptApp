const progressbar = document.querySelector(".progress");
const loader_container = document.querySelector("#loader_container");

const changeProgress = (progress) => {
    progressbar.style.width = `${progress}%`;
};

const changeOpacityBar = (progress) => {
    progressbar.style.setProperty("opacity", `${progress}`, "important");

};

const changeOpacity = (progress) => {
    loader_container.style.setProperty("opacity", `${progress}`, "important");

};

const remove = () => {

    loader_container.remove();
};


progressbar.style.setProperty("transition", "width 0.8s ease", "important");

/* change progress after 1 second (only for showcase) */
setTimeout(() => changeOpacityBar(1), 800);
setTimeout(() => changeProgress(0), 0);

setTimeout(() => changeProgress(45), 1000);
setTimeout(() => changeProgress(85), 3000);
setTimeout(() => changeProgress(98), 3966);
setTimeout(() => changeProgress(100), 4800);
setTimeout(() => changeOpacity(0), 5500);

setTimeout(() => remove(), 6500);