/*
* Version: 5.0.0
* Template: SocialV - Responsive Bootstrap 5 Admin Dashboard Template
* Author: iqonic.design
* Author URL: https://iqonic.design/
* Design and Developed by: iqonic.design
* Description: This file contains the script for initialize & listener Template.
*/

(function () {
    this.IQUtils = function (params) {
    }


    // save session storage value
    this.IQUtils.saveSessionStorage = function (key, value) {
        window.sessionStorage.setItem(key, value);
    }

    // get session storage value
    this.IQUtils.getSessionStorage = function (key) {
        return window.sessionStorage.getItem(key);
    }

    // remove session storage value
    this.IQUtils.removeSessionStorage = function (key) {
        window.sessionStorage.removeItem(key);
    }

    // save local storage value
    this.IQUtils.saveLocalStorage = function (key, value) {
        window.localStorage.setItem(key, value);
    }

    // get local storage value
    this.IQUtils.getLocalStorage = function (key) {
        return window.localStorage.getItem(key);
    }

    // remove local storage value
    this.IQUtils.removeLocalStorage = function (key) {
        window.localStorage.removeItem(key);
    }

    // get cookie value
    this.IQUtils.getCookie = function (cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    }

    // set cookie value
    this.IQUtils.setCookie = function (cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
        var expires = "expires=" + d.toUTCString();
        document.cookie = cname + "=" + cvalue + "; " + expires;
    }

    // remove cookie value
    this.IQUtils.removeCookie = function (cname) {
        document.cookie = cname + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    }

    // check storage key exist function
    this.IQUtils.checkStorageKey = function (key) {
        if (window.localStorage.getItem(key) === null) {
            return false;
        } else {
            return true;
        }
    }

    // check session storage key exist function
    this.IQUtils.checkSessionStorageKey = function (key) {
        if (window.sessionStorage.getItem(key) === null) {
            return false;
        } else {
            return true;
        }
    }

    // check cookie key exist function
    this.IQUtils.checkCookieKey = function (key) {
        if (this.getCookie(key) === "") {
            return false;
        } else {
            return true;
        }
    }

    // check value exist function
    this.IQUtils.checkValue = function (value) {
        if (value === null || value === undefined || value === "") {
            return false;
        } else {
            return true;
        }
    }

    // check all storage from key exist or not
    this.IQUtils.checkAllStorageKey = function (key) {
        if (this.checkStorageKey(key) || this.checkSessionStorageKey(key) || this.checkCookieKey(key)) {
            return true;
        } else {
            return false;
        }
    }

    // check storage array by paramerts exist function
    this.IQUtils.checkStorageArray = function (key, storages) {
        let result = true;
        let obj = {}
        for (var i = 0; i < storages.length; i++) {
            switch (storages[i]) {
                case 'localStorage':
                    if (this.checkStorageKey(key)) {
                        result = false;
                        obj.storage = 'localStorage';
                        obj.key = this.getLocalStorage(key);
                    }
                    break;

                case 'sessionStorage':
                    if (this.checkSessionStorageKey(key)) {
                        result = false;
                        obj.storage = 'sessionStorage';
                        obj.key = this.getSessionStorage(key);
                    }
                    break;

                case 'cookie':
                    if (this.checkCookieKey(key)) {
                        result = false;
                        obj.cookie = false;
                    }
                    break;

                default:
                    break;
            }
        }
        obj.result = result;
        return obj;
    }

    // get url parameter value
    this.IQUtils.getUrlParameter = function (name) {
        name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
        const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
        const results = regex.exec(location.search);
        return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
    }

    // get query string value
    this.IQUtils.getQueryString = function (name) {
        name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
        const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
        const results = regex.exec(location.search);
        return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
    }

    // get element by selector
    this.IQUtils.getElem = function (selector, elem = document) {
        return elem.querySelector(selector);
    }


    this.IQUtils.getElems = function (selector, elem = document) {
        return elem.querySelectorAll(selector);
    }

    this.IQUtils.setContent = function (selector, content) {
        let _newElem = selector
        if(_.isString(_newElem)){
            _newElem = IQUtils.getElems(selector);;
        }
        if(typeof _newElem.length !== typeof undefined){
            _.forEach(_newElem, function (elem) {
                const leftJoin = elem.getAttribute('data-leftJoin') !== null ? elem.getAttribute('data-leftJoin') : '';
                const rightJoin = elem.getAttribute('data-rightJoin') !== null ? elem.getAttribute('data-rightJoin') : '';
                elem.innerHTML =  leftJoin + content +  rightJoin;
            });
        }
    }

    // class add function
    this.IQUtils.addClass = function (elem,...className) {
        let _newElem = elem
        if(_.isString(_newElem)){
            _newElem = IQUtils.getElems(elem);;
        }
        if(_newElem.length !== undefined){
            _.forEach(_newElem, function (elem) {
                _.forEach(className, function (className) {
                    elem.classList.add(className);
                });
            });
        } else {
            _.forEach(className, function (className) {
                _newElem.classList.add(className);
            });
        }

    }

    // class remove function
    this.IQUtils.removeClass = function (elem,...className) {
        let _newElem = elem
        if(_.isString(_newElem)){
            _newElem = IQUtils.getElems(elem);;
        }
        if(_newElem.length !== undefined){
            _.forEach(_newElem, function (elem) {
                _.forEach(className, function (className) {
                    elem.classList.remove(className);
                });
            });
        } else {
            _.forEach(className, function (className) {
                _newElem.classList.remove(className);
            });
        }
    }

    // class toggle function
    this.IQUtils.toggleClass = function (elem,className) {
        elem.classList.toggle(className);
    }

    // class has function
    this.IQUtils.hasClass = function (elem,className) {
        return elem.classList.contains(className);
    }

    // get attribute value
    this.IQUtils.getAttr = function (elem,attr) {
        return elem.getAttribute(attr);
    }

    // set attribute value
    this.IQUtils.setAttr = function (elems,object) {
        let _newElem = elems
        if(_.isString(_newElem)){
            _newElem = IQUtils.getElems(elems);;
        }
        _.forEach(_newElem, function (elem) {
            elem.setAttribute(object.prop, object.value);
        })
    }

    // remove attribute value
    this.IQUtils.removeAttr = function (elem,attr) {
        elem.removeAttribute(attr);
    }

    // update style value
    this.IQUtils.setStyle = function (elems,object) {
        for (var key in object) {
            let _newElem = elems
            if(_.isString(_newElem)){
                _newElem = IQUtils.getElems(elems);;
            }
            _.forEach(_newElem, function (elem) {
                elem.style[key] = object[key];
            })
        }
    }

    // get element position
    this.IQUtils.getPosition = function (elem) {
        var xPosition = 0;
        var yPosition = 0;

        while (elem) {
            xPosition += (elem.offsetLeft - elem.scrollLeft + elem.clientLeft);
            yPosition += (elem.offsetTop - elem.scrollTop + elem.clientTop);
            elem = elem.offsetParent;
        }
        return {
            x: xPosition,
            y: yPosition
        };
    }

    // get element width
    this.IQUtils.getWidth = function (elem) {
        return elem.offsetWidth;
    }

    // get element height
    this.IQUtils.getHeight = function (elem) {
        return elem.offsetHeight;
    }

    // create event
    this.IQUtils.createEvent = (eventName, eventData) => {
        return new Event(eventName, eventData);
    }

    // deep merge function
    this.IQUtils.mergeDeep = (target, ...sources) => {
        if (!sources.length) return target;
        const source = sources.shift();

        if (_.isObject(target) && _.isObject(source)) {
            for (const key in source) {
            if (_.isObject(source[key])) {
                if (!target[key]) Object.assign(target, { [key]: {} });
                IQUtils.mergeDeep(target[key], source[key]);
            } else {
                Object.assign(target, { [key]: source[key] });
            }
            }
        }

        return IQUtils.mergeDeep(target, ...sources);
    }

    // get style root variables function
    this.IQUtils.getRootVars = (property, elem = document.body) => {
        let _newElem = elem
            if(_.isString(_newElem)){
                _newElem = IQUtils.getElems(elems);;
            }
        return getComputedStyle(elem).getPropertyValue(property).trim() || null;

    }

    // add or update css root variables function
    this.IQUtils.setRootVariables = (variables) => {
        const _root = document.documentElement;
        const _variables = variables;
        _.forEach(_variables, function (value, key) {
            _root.style.setProperty(key, value);
        });
    }

    // remove css root variables function
    this.IQUtils.removeRootVariables = (variables) => {
        const _root = document.documentElement;
        const _variables = variables;
        _.forEach(_variables, function (value, key) {
            _root.style.removeProperty(key);
        });
    }

    this.IQUtils.getVariableColor = () => {
      let prefix = getComputedStyle(document.body).getPropertyValue('--prefix') || 'bs-';
      if (prefix) {
        prefix = prefix.trim()
      }
      const color1 = getComputedStyle(document.body).getPropertyValue(`--${prefix}primary`);
      const color2 = getComputedStyle(document.body).getPropertyValue(`--${prefix}info`);
      const color3 = getComputedStyle(document.body).getPropertyValue(`--${prefix}primary-tint-20`);
      const color4 = getComputedStyle(document.body).getPropertyValue(`--${prefix}warning`);
      return {
        primary: color1.trim(),
        info: color2.trim(),
        warning: color4.trim(),
        primary_light: color3.trim(),
      };
    }

    return this.IQUtils;
})();
