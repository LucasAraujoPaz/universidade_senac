/**
 * @typedef {{
 * id: number,
 * cpf: number,
 * nome: string,
 * dataDeNascimento: Date,
 * email: string,
 * telefone: number,
 * status: number | string
 * }} IAluno
 */

/** 
 * @implements {IAluno}
 * @implements {IEntidadeComId}
 */
class Aluno {

    /**
     * @param {number} id
     * @param {number} cpf
     * @param {string} nome
     * @param {Date} dataDeNascimento
     * @param {string} email
     * @param {number} telefone
     * @param {number | string} status 
     */
    constructor(id, cpf, nome,dataDeNascimento, email, telefone, status) {
            this.id = id;
            this.cpf = cpf;
            this.nome = nome;
            this.dataDeNascimento = dataDeNascimento;
            this.email = email;
            this.telefone = telefone;
            this.status = status;
    }
}

/** @type {ICRUD<Aluno>} */
Aluno.CRUD = {
    
    URL: Internet.URLS.URL_ALUNOS,

    async listar() {
        /** @type {Aluno[]} */
        const alunos = await Internet.getJson(this.URL)
        alunos.forEach(aluno => aluno.dataDeNascimento = sanitizarData(aluno.dataDeNascimento));

        return alunos;
    },
    async obter(id) {
        /** @type {Aluno} */
        const aluno = await Internet.getJson(this.URL + "/" + id);
        aluno.dataDeNascimento = sanitizarData(aluno.dataDeNascimento);

        return aluno;
    },
    async criar(aluno) {
        return await Internet.post(this.URL, aluno);
    },
    async editar(aluno) {
        return await Internet.put(this.URL, aluno);
    },
    async deletar(id) {
        await Internet.delete(this.URL + "/" + id);
    }
}

/** @type {IFormulario<Aluno>} */
Aluno.Formulario = {

    nomeDoLink: "linkAlunos",
    nomeDoFormulario: "aluno",

    async preencher(aluno) {
    
        await renderizarCorpo("alunos/aluno.html");

        Formulario.preencher(Aluno, aluno);

        const elements = document.forms.namedItem(this.nomeDoFormulario)?.elements;

        if (! (elements && aluno) ) 
            return;

        // @ts-expect-error
        elements.dataDeNascimento.value = 
            aluno.dataDeNascimento.toLocaleDateString("en-CA");
    },

    obter() {
            
        const elements = document.forms.namedItem(this.nomeDoFormulario)?.elements;
        if (!elements)
            throw new Error("Erro no formulário.");

        const aluno = new Aluno( // @ts-expect-error
            elements.id.value.length == 0 ? -1 : elements.id.value, // @ts-expect-error
            elements.cpf.value, // @ts-expect-error
            elements.nome.value, // @ts-expect-error
            sanitizarData(elements.dataDeNascimento.value), // @ts-expect-error
            elements.email.value, // @ts-expect-error
            elements.telefone.value, // @ts-expect-error
            elements.status.value.length == 0 ? 1 : elements.status.value);
        
        return aluno;
    }
}