# Fugerit Document Generation Framework (fj-doc)

## OpenPDF Renderer (PDF/RTF/HTML)(fj-doc-mod-opendf)

[back to fj-doc index](https://github.com/fugerit-org/fj-doc.git)  

*Description* :  
Type handlers for generating documents in PDF, RTF and HTML formats using [OpenPDF](https://github.com/LibrePDF/OpenPDF) / [OpenRTF](https://github.com/LibrePDF/OpenRTF) (which is basically a fork of itext project)

*Status* :  
All basic features are implemented.  

*Quickstart* :  
Basically this is only a type handler, see core library [fj-doc-base](https://github.com/fugerit-org/fj-doc.git).  
NOTE: If you have any special need you can open a pull request or create your own handler based on this.

See [CHANGELOG.md](CHANGELOG.md) for details.

*Native support* :   
Native metadata for GraalVM have been included, but on some platforms (i.e. MacOS) it will not work, with this error : 

``` 
dispatch failed: java.lang.UnsatisfiedLinkError: no awt in java.library.path] with root cause

java.lang.UnsatisfiedLinkError: no awt in java.library.path
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.jdk.NativeLibrarySupport.loadLibraryRelative(NativeLibrarySupport.java:120) ~[na:na]
```

[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=fugerit-org_fj-doc-mod-openpdf)](https://sonarcloud.io/summary/new_code?id=fugerit-org_fj-doc-mod-openpdf)