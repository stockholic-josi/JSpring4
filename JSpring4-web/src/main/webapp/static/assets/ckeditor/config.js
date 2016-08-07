/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	/*
	config.toolbar =[
	                 ['Source','-','Cut','Copy','Paste','PasteText','PasteFromWord','Undo','Redo','SelectAll','RemoveFormat'],
	                 '/',
	                 ['Bold','Italic','Underline','Strike', 'Subscript','Superscript'],
	                 ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
	                 ['NumberedList','BulletedList','Outdent','Indent','Blockquote','CreateDiv'],
	                 ['Image','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
	                 ['Styles','Format','Font','FontSize','TextColor','BGColor','Maximize', 'ShowBlocks']
	             ];
	  */
	/*
	config.toolbar =[
	                 ['Source','-','Cut','Copy','Paste','PasteText','PasteFromWord','Undo','Redo','SelectAll','RemoveFormat'],
	                
	                 ['Bold','Italic','Underline','Strike', 'Subscript','Superscript'],
	                 ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
	                 ['NumberedList','BulletedList','Outdent','Indent','Blockquote','CreateDiv'],
	                 ['Image','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
	                 ['Styles','Format','Font','FontSize','TextColor','BGColor','Maximize', 'ShowBlocks']
	             ];
	*/
	config.height = '450px';
	
	config.font_names = '돋움; Nanum Gothic Coding;맑은 고딕; 바탕; 궁서; Quattrocento Sans;' + CKEDITOR.config.font_names;
};
