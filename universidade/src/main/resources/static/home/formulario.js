/**
 * @template T
 * @typedef {{
 * readonly nomeDoLink: string,
 * readonly nomeDoFormulario: string,
 * preencher: (objeto: T?) => Promise<void>,
 * obter: () => T
 * }} IFormulario<T>
 */
 
 class Formulario {

    /**
     * @template T
     * @param {IFormularioCRUD<T & IEntidadeComId>} classe
     * @param {(implements & T)?} objeto
     */
    static preencher(classe, objeto) {
    
        const form = document.forms.namedItem(classe.Formulario.nomeDoFormulario);
        const elements = form?.elements;
        if (!elements)
            return;

        if (objeto) {

            for (const element of elements)
                if (element instanceof HTMLInputElement && objeto[element.name] !== undefined)
                    element.value = objeto[element.name];

            form.onsubmit = async event => {
                event.preventDefault();
                await classe.CRUD.editar(classe.Formulario.obter());
                await Lista.renderizarLista(classe);
            }
            return;
        }
        
        form.onsubmit = async event => {
            event.preventDefault();
            await classe.CRUD.criar(classe.Formulario.obter());
            await Lista.renderizarLista(classe);
        }
    }
}