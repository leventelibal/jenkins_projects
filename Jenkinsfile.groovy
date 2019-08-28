node{
    stage("Pull Repo"){
        properties([parameters([string(defaultValue: '34.255.1.240', description: 'Please provide IP', name: 'Environment ', trim: true)])])
        git "https://github.com/miguelgrinberg/flask-examples.git"
    }
    stage("Install Requirments"){
        sh "virtualenv /tmp/venv"
        sh ". venv/bin/activate"
        
    }
    stage("Pip Install"){
        sh "pip install -r requirements.txt"
    }
    stage ("Run App"){
        sh "python /tmp/venv/01-hello-world/hello.py"
    }
}