import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent {
  selectedFiles: FileList | null = null;
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private http: HttpClient) {}

  onFileSelected(event: any) {
    this.selectedFiles = event.target.files;
  }
  

  uploadFiles() {
    if (this.selectedFiles) {
      const formData = new FormData();
      for (let i = 0; i < this.selectedFiles.length; i++) {
        formData.append('files', this.selectedFiles[i]);
      }

      this.http.post<any>('/file/upload', formData).subscribe(
        (response) => {
          this.successMessage = 'Files uploaded successfully!';
          this.errorMessage = '';
        },
        (error) => {
          this.errorMessage = 'File upload failed.';
          this.successMessage = '';
        }
      );
    }
  }
}
