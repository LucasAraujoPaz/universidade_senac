class Internet {

    static #a = document.createElement("a");
    static { this.#a.href = ""; }

    static #URLS = Object.freeze({
        URL_BASE: this.#a.origin, //"http://localhost:8080"
        URL_ALUNOS: this.#a.origin + "/alunos",
        URL_FORNECEDORES: this.#a.origin + "/fornecedores",
        URL_PROFESSORES: this.#a.origin + "/professores"
    });

    static get URLS() { return this.#URLS; }

    /**
     * @param {RequestInfo} url
     */
    static async getText(url) {

        try {
            const response = await fetch(url);
            return await response.text();
        } catch (reason) {
            console.error(reason);
            return null;
        }
    }

    /**
     * @param {RequestInfo} url
     */
    static async getJson(url) {

        try {
            const response = await fetch(url);
            return await response.json();
        } catch (reason) {
            console.error(reason);
            return null;
        }
    }

    /**
     * @param {RequestInfo} url
     * @param {any} object
     */
    static async post(url, object) {
        
        try {
            const response = await fetch(url, {
                method: "POST",
                body: JSON.stringify(object),
                headers: {
                    "Content-Type": "application/json"
                }
            });
            return await response.json();
        } catch (reason) {
            console.error(reason);
            return null;
        }
    }

    /**
     * @param {RequestInfo} url
     * @param {any} object
     */
    static async put(url, object) {
        
        try {
            const response = await fetch(url, {
                method: "PUT",
                body: JSON.stringify(object),
                headers: {
                    "Content-Type": "application/json"
                }
            });
            return await response.json();
        } catch (reason) {
            console.error(reason);
            return null;
        }
    }

    /** @param {RequestInfo} url */
    static async delete(url) {
        
        try {
            const response = await fetch(url, {
                method: "DELETE"
            });
            return response.ok;
        } catch (reason) {
            console.error(reason);
            return false;
        }
    }

    /**
     * @param {string} url
     */
    static async loadHtml(url) {
        const html = await this.getText(url);
        const container = document.createElement("div");
        container.innerHTML = html ?? "";
        /*const baseUrl = this.#getBaseUrl(url);
        const scripts = container.querySelectorAll("script");
        for (const script of scripts) {
            const src = script.getAttribute("src");
            if (!src) 
                continue;
            script.remove();
            const urlDoScript = new URL(src, baseUrl);
            const js = await this.getText(urlDoScript.href) ?? "";
            const newScript = document.createElement("script");
            newScript.append(js);
            container.append(newScript);
        }*/
    
        return container.children;
    }
    
    /** @param {string} url 
    static #getBaseUrl(url) {
        const a = document.createElement("a");
        a.href = url;
        const baseUrl = new URL('./', a.href)
        return baseUrl.href;
    }*/
}