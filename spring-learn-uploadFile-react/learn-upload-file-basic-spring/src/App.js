import logo from './logo.svg';
import './App.css';
import UploadFileComponent from "./components/UploadFileComponent"

function App() {
  return (
    <div className="container" style={{ width: "600px" }}>
      <div style={{ margin: "20px" }}>
        <h3>Phuc DN Demo Upload File Spring boot</h3>
        <h4>React upload Files</h4>
      </div>

      <UploadFileComponent />
    </div>
  );
}

export default App;
