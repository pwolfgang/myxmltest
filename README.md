# XML Test Classes

This project defines three classes to be used to test XML data.
The TestElementFactory generates new documents or elements from an input string.
The StaxElementFactory creates a StaxEventReader pointing to a start of an element within an input string.
The ElementComparator compares two Elements for equality after normalizing them by removing any whitespace between child elements.