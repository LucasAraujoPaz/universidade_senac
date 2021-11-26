class Lista {

    /**
     * @template T
     * @param {IFormularioCRUD<T>} classe
     */
    static async renderizarLista(classe) {
        await renderizarCorpo("lista/lista.html");
        await this.#preencher(classe);
    }

    /**
     * @template T
     * @param {IFormularioCRUD<T>} classe
     */
    static async #preencher(classe) {

        const lista = await classe.CRUD.listar();
        // @ts-expect-error
        this.#listar(lista);

        /**@type {HTMLButtonElement}*/
        const criar = (document.querySelector("#lista [name='criar']"));
        /**@type {HTMLButtonElement}*/
        const editar = (document.querySelector("#lista [name='editar']"));
            /**@type {HTMLButtonElement}*/
        const deletar = (document.querySelector("#lista [name='deletar']"));

        criar.onclick = async () => await classe.Formulario.preencher(null);
        editar.onclick = async () => {
            const id = Number(this.#obterIdSelecionado());
            if (isNaN(id)) 
                return;

            const objeto = await classe.CRUD.obter(id);
            await classe.Formulario.preencher(objeto);
        };
        deletar.onclick = () => {
            const id = Number(this.#obterIdSelecionado());
            if (isNaN(id)) 
                return;

            classe.CRUD.deletar(id);
            document.links.namedItem(classe.Formulario.nomeDoLink)?.click()
        };
    }

    /** @param {(implements & IEntidadeComId)[]} lista */
    static #listar(lista) {

        if (isNaN(Number(lista?.[0]?.id)))
            return;

        const options = lista.map(elemento => {
            const option = document.createElement("option");
            option.value = elemento.id.toString();
            option.textContent = JSON.stringify(elemento);
            return option;
        });

        document.querySelector("#lista [name='seletor']")?.append(...options);
    }
    
    static #obterIdSelecionado() {

        /**@type {HTMLSelectElement} */
        const select = (document.querySelector("#lista [name='seletor']"));
        const id = select.selectedOptions[0]?.value;
        return id;
    }
}