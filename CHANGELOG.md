# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added

- document metadata handling (doc-title, doc-author, doc-language, doc-subject, doc-creator)

### Changed

- fj-doc version set to 3.1.3

## [1.1.0-sa.1] - 2023-09-16

### Added

- [Sonar cloud workflow](.github/workflows/sonarcloud-maven.yml)
- [Maven build workflow](.github/workflows/build_maven_package.yml)
- [workflow deploy on branch deploy](.github/workflows/deploy_maven_package.yml)
- Sonar Cloud coverage badge
- keep a changelog badge

### Changed

- fj-doc version set to 3.0.4
- changelog format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/)

## [1.0.0] - 2023-08-30

### Added

- Added license and maven repo central badge

### Changed

- Updated parent version to fj-doc 1.5.4

## [0.2.0] - 2023-08-20

### Added

- Added sonar cloud quality gate (Deep code review)

### Changed

- Updated parent version to fj-doc 1.5.0
- Refactor to avoid some deprecation notice by OpenPDF

## [0.1.0] - 2023-08-13

### Added

- Added JUnit for basic testing

### Changed

- Updated parent version to fj-doc 1.4.4
- Typos in documentation

## [0.1.0-rc.001] - 2023-07-22

### Added

- Porting of fj-doc-mod-itext based on [OpenPDF](https://github.com/LibrePDF/OpenPDF) / [OpenRTF](https://github.com/LibrePDF/OpenRTF)
