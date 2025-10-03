package com.vulpuslabs.scapegrace;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
//[/user-imports]


public class Scapegrace extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public Scapegrace( long moduleID, VoltageObjects voltageObjects )
{
   super( moduleID, voltageObjects, "Scapegrace", ModuleType.ModuleType_Effect, 2.0 );

   InitializeControls();


   canBeBypassed = false;
   SetSkin( "89dee194d4ec4b2184cc028be0dfae12" );
}

void InitializeControls()
{

   inputLeft = new VoltageAudioJack( "inputLeft", "Left Input Jack", this, JackType.JackType_AudioInput );
   AddComponent( inputLeft );
   inputLeft.SetWantsMouseNotifications( false );
   inputLeft.SetPosition( 14, 52 );
   inputLeft.SetSize( 25, 25 );
   inputLeft.SetSkin( "Mini Jack 25px" );

   textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "L" );
   AddComponent( textLabel1 );
   textLabel1.SetWantsMouseNotifications( false );
   textLabel1.SetPosition( 9, 34 );
   textLabel1.SetSize( 35, 15 );
   textLabel1.SetEditable( false, false );
   textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel1.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel1.SetBorderSize( 1 );
   textLabel1.SetMultiLineEdit( false );
   textLabel1.SetIsNumberEditor( false );
   textLabel1.SetNumberEditorRange( 0, 100 );
   textLabel1.SetNumberEditorInterval( 1 );
   textLabel1.SetNumberEditorUsesMouseWheel( false );
   textLabel1.SetHasCustomTextHoverColor( false );
   textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel1.SetFont( "Arial", 10, true, false );

   textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "L" );
   AddComponent( textLabel6 );
   textLabel6.SetWantsMouseNotifications( false );
   textLabel6.SetPosition( 62, 312 );
   textLabel6.SetSize( 35, 15 );
   textLabel6.SetEditable( false, false );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel6.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel6.SetBorderSize( 1 );
   textLabel6.SetMultiLineEdit( false );
   textLabel6.SetIsNumberEditor( false );
   textLabel6.SetNumberEditorRange( 0, 100 );
   textLabel6.SetNumberEditorInterval( 1 );
   textLabel6.SetNumberEditorUsesMouseWheel( false );
   textLabel6.SetHasCustomTextHoverColor( false );
   textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel6.SetFont( "Arial", 10, true, false );

   textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "SCAPEGRACE" );
   AddComponent( textLabel2 );
   textLabel2.SetWantsMouseNotifications( false );
   textLabel2.SetPosition( 0, 0 );
   textLabel2.SetSize( 142, 15 );
   textLabel2.SetEditable( false, false );
   textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel2.SetBorderSize( 1 );
   textLabel2.SetMultiLineEdit( false );
   textLabel2.SetIsNumberEditor( false );
   textLabel2.SetNumberEditorRange( 0, 100 );
   textLabel2.SetNumberEditorInterval( 1 );
   textLabel2.SetNumberEditorUsesMouseWheel( false );
   textLabel2.SetHasCustomTextHoverColor( false );
   textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel2.SetFont( "Arial", 10, true, false );

   textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "VULPUS LABS" );
   AddComponent( textLabel3 );
   textLabel3.SetWantsMouseNotifications( false );
   textLabel3.SetPosition( 0, 345 );
   textLabel3.SetSize( 142, 15 );
   textLabel3.SetEditable( false, false );
   textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel3.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel3.SetBorderSize( 1 );
   textLabel3.SetMultiLineEdit( false );
   textLabel3.SetIsNumberEditor( false );
   textLabel3.SetNumberEditorRange( 0, 100 );
   textLabel3.SetNumberEditorInterval( 1 );
   textLabel3.SetNumberEditorUsesMouseWheel( false );
   textLabel3.SetHasCustomTextHoverColor( false );
   textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel3.SetFont( "Arial", 10, true, false );

   inputRight = new VoltageAudioJack( "inputRight", "Right Input Jack", this, JackType.JackType_AudioInput );
   AddComponent( inputRight );
   inputRight.SetWantsMouseNotifications( false );
   inputRight.SetPosition( 51, 52 );
   inputRight.SetSize( 25, 25 );
   inputRight.SetSkin( "Mini Jack 25px" );

   textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "R" );
   AddComponent( textLabel4 );
   textLabel4.SetWantsMouseNotifications( false );
   textLabel4.SetPosition( 46, 34 );
   textLabel4.SetSize( 35, 15 );
   textLabel4.SetEditable( false, false );
   textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel4.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel4.SetBorderSize( 1 );
   textLabel4.SetMultiLineEdit( false );
   textLabel4.SetIsNumberEditor( false );
   textLabel4.SetNumberEditorRange( 0, 100 );
   textLabel4.SetNumberEditorInterval( 1 );
   textLabel4.SetNumberEditorUsesMouseWheel( false );
   textLabel4.SetHasCustomTextHoverColor( false );
   textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel4.SetFont( "Arial", 10, true, false );

   textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "R" );
   AddComponent( textLabel5 );
   textLabel5.SetWantsMouseNotifications( false );
   textLabel5.SetPosition( 99, 312 );
   textLabel5.SetSize( 35, 15 );
   textLabel5.SetEditable( false, false );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel5.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel5.SetBorderSize( 1 );
   textLabel5.SetMultiLineEdit( false );
   textLabel5.SetIsNumberEditor( false );
   textLabel5.SetNumberEditorRange( 0, 100 );
   textLabel5.SetNumberEditorInterval( 1 );
   textLabel5.SetNumberEditorUsesMouseWheel( false );
   textLabel5.SetHasCustomTextHoverColor( false );
   textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel5.SetFont( "Arial", 10, true, false );

   replayTrigger = new VoltageAudioJack( "replayTrigger", "Replay Trigger", this, JackType.JackType_AudioInput );
   AddComponent( replayTrigger );
   replayTrigger.SetWantsMouseNotifications( false );
   replayTrigger.SetPosition( 94, 52 );
   replayTrigger.SetSize( 25, 25 );
   replayTrigger.SetSkin( "Mini Jack 25px" );

   textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "TRIG" );
   AddComponent( textLabel7 );
   textLabel7.SetWantsMouseNotifications( false );
   textLabel7.SetPosition( 89, 34 );
   textLabel7.SetSize( 35, 15 );
   textLabel7.SetEditable( false, false );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel7.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel7.SetBorderSize( 1 );
   textLabel7.SetMultiLineEdit( false );
   textLabel7.SetIsNumberEditor( false );
   textLabel7.SetNumberEditorRange( 0, 100 );
   textLabel7.SetNumberEditorInterval( 1 );
   textLabel7.SetNumberEditorUsesMouseWheel( false );
   textLabel7.SetHasCustomTextHoverColor( false );
   textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel7.SetFont( "Arial", 10, true, false );

   outputRight = new VoltageAudioJack( "outputRight", "Right Output Jack", this, JackType.JackType_AudioOutput );
   AddComponent( outputRight );
   outputRight.SetWantsMouseNotifications( false );
   outputRight.SetPosition( 104, 285 );
   outputRight.SetSize( 25, 25 );
   outputRight.SetSkin( "Mini Jack 25px" );

   outputLeft = new VoltageAudioJack( "outputLeft", "Left Output Jack", this, JackType.JackType_AudioOutput );
   AddComponent( outputLeft );
   outputLeft.SetWantsMouseNotifications( false );
   outputLeft.SetPosition( 67, 285 );
   outputLeft.SetSize( 25, 25 );
   outputLeft.SetSkin( "Mini Jack 25px" );

   mixCv = new VoltageAudioJack( "mixCv", "Mix Control", this, JackType.JackType_AudioInput );
   AddComponent( mixCv );
   mixCv.SetWantsMouseNotifications( false );
   mixCv.SetPosition( 5, 247 );
   mixCv.SetSize( 25, 25 );
   mixCv.SetSkin( "Mini Jack 25px" );

   mixKnob = new VoltageKnob( "mixKnob", "Mix", this, 0.0, 1.0, 0.3 );
   AddComponent( mixKnob );
   mixKnob.SetWantsMouseNotifications( false );
   mixKnob.SetPosition( 35, 247 );
   mixKnob.SetSize( 25, 25 );
   mixKnob.SetSkin( "Plastic Blue" );
   mixKnob.SetRange( 0.0, 1.0, 0.3, false, 0 );
   mixKnob.SetKnobParams( 215, 145 );
   mixKnob.DisplayValueInPercent( false );
   mixKnob.SetKnobAdjustsRing( true );

   textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "MIX" );
   AddComponent( textLabel8 );
   textLabel8.SetWantsMouseNotifications( false );
   textLabel8.SetPosition( 62, 243 );
   textLabel8.SetSize( 46, 35 );
   textLabel8.SetEditable( false, false );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel8.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel8.SetBorderSize( 1 );
   textLabel8.SetMultiLineEdit( false );
   textLabel8.SetIsNumberEditor( false );
   textLabel8.SetNumberEditorRange( 0, 100 );
   textLabel8.SetNumberEditorInterval( 1 );
   textLabel8.SetNumberEditorUsesMouseWheel( false );
   textLabel8.SetHasCustomTextHoverColor( false );
   textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel8.SetFont( "Arial", 10, true, false );

   feedbackCv = new VoltageAudioJack( "feedbackCv", "Feedback Control", this, JackType.JackType_AudioInput );
   AddComponent( feedbackCv );
   feedbackCv.SetWantsMouseNotifications( false );
   feedbackCv.SetPosition( 5, 207 );
   feedbackCv.SetSize( 25, 25 );
   feedbackCv.SetSkin( "Mini Jack 25px" );

   feedbackKnob = new VoltageKnob( "feedbackKnob", "Feedback", this, 0.0, 1.0, 0 );
   AddComponent( feedbackKnob );
   feedbackKnob.SetWantsMouseNotifications( false );
   feedbackKnob.SetPosition( 35, 207 );
   feedbackKnob.SetSize( 25, 25 );
   feedbackKnob.SetSkin( "Plastic Blue" );
   feedbackKnob.SetRange( 0.0, 1.0, 0, false, 0 );
   feedbackKnob.SetKnobParams( 215, 145 );
   feedbackKnob.DisplayValueInPercent( false );
   feedbackKnob.SetKnobAdjustsRing( true );

   textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "FBCK" );
   AddComponent( textLabel9 );
   textLabel9.SetWantsMouseNotifications( false );
   textLabel9.SetPosition( 62, 203 );
   textLabel9.SetSize( 46, 35 );
   textLabel9.SetEditable( false, false );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel9.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel9.SetBorderSize( 1 );
   textLabel9.SetMultiLineEdit( false );
   textLabel9.SetIsNumberEditor( false );
   textLabel9.SetNumberEditorRange( 0, 100 );
   textLabel9.SetNumberEditorInterval( 1 );
   textLabel9.SetNumberEditorUsesMouseWheel( false );
   textLabel9.SetHasCustomTextHoverColor( false );
   textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel9.SetFont( "Arial", 10, true, false );

   widthCv = new VoltageAudioJack( "widthCv", "Width Control", this, JackType.JackType_AudioInput );
   AddComponent( widthCv );
   widthCv.SetWantsMouseNotifications( false );
   widthCv.SetPosition( 6, 167 );
   widthCv.SetSize( 25, 25 );
   widthCv.SetSkin( "Mini Jack 25px" );

   widthKnob = new VoltageKnob( "widthKnob", "Width", this, 0.0, 1.0, 0 );
   AddComponent( widthKnob );
   widthKnob.SetWantsMouseNotifications( false );
   widthKnob.SetPosition( 36, 167 );
   widthKnob.SetSize( 25, 25 );
   widthKnob.SetSkin( "Plastic Blue" );
   widthKnob.SetRange( 0.0, 1.0, 0, false, 0 );
   widthKnob.SetKnobParams( 215, 145 );
   widthKnob.DisplayValueInPercent( false );
   widthKnob.SetKnobAdjustsRing( true );

   textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "WIDTH" );
   AddComponent( textLabel10 );
   textLabel10.SetWantsMouseNotifications( false );
   textLabel10.SetPosition( 63, 163 );
   textLabel10.SetSize( 46, 35 );
   textLabel10.SetEditable( false, false );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel10.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel10.SetBorderSize( 1 );
   textLabel10.SetMultiLineEdit( false );
   textLabel10.SetIsNumberEditor( false );
   textLabel10.SetNumberEditorRange( 0, 100 );
   textLabel10.SetNumberEditorInterval( 1 );
   textLabel10.SetNumberEditorUsesMouseWheel( false );
   textLabel10.SetHasCustomTextHoverColor( false );
   textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel10.SetFont( "Arial", 10, true, false );

   fadeCv = new VoltageAudioJack( "faceCv", "Fade Control", this, JackType.JackType_AudioInput );
   AddComponent( fadeCv );
   fadeCv.SetWantsMouseNotifications( false );
   fadeCv.SetPosition( 5, 127 );
   fadeCv.SetSize( 25, 25 );
   fadeCv.SetSkin( "Mini Jack 25px" );

   fadeKnob = new VoltageKnob( "fadeKnob", "Fade", this, 0.0, 1.0, 0.5 );
   AddComponent( fadeKnob );
   fadeKnob.SetWantsMouseNotifications( false );
   fadeKnob.SetPosition( 35, 127 );
   fadeKnob.SetSize( 25, 25 );
   fadeKnob.SetSkin( "Plastic Blue" );
   fadeKnob.SetRange( 0.0, 1.0, 0.5, false, 0 );
   fadeKnob.SetKnobParams( 215, 145 );
   fadeKnob.DisplayValueInPercent( false );
   fadeKnob.SetKnobAdjustsRing( true );

   textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "FADE" );
   AddComponent( textLabel11 );
   textLabel11.SetWantsMouseNotifications( false );
   textLabel11.SetPosition( 62, 123 );
   textLabel11.SetSize( 46, 35 );
   textLabel11.SetEditable( false, false );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel11.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel11.SetBorderSize( 1 );
   textLabel11.SetMultiLineEdit( false );
   textLabel11.SetIsNumberEditor( false );
   textLabel11.SetNumberEditorRange( 0, 100 );
   textLabel11.SetNumberEditorInterval( 1 );
   textLabel11.SetNumberEditorUsesMouseWheel( false );
   textLabel11.SetHasCustomTextHoverColor( false );
   textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel11.SetFont( "Arial", 10, true, false );

   lengthCv = new VoltageAudioJack( "lengthCv", "Length Control", this, JackType.JackType_AudioInput );
   AddComponent( lengthCv );
   lengthCv.SetWantsMouseNotifications( false );
   lengthCv.SetPosition( 5, 87 );
   lengthCv.SetSize( 25, 25 );
   lengthCv.SetSkin( "Mini Jack 25px" );

   lengthKnob = new VoltageKnob( "lengthKnob", "Length", this, 0.0, 1.0, 0.5 );
   AddComponent( lengthKnob );
   lengthKnob.SetWantsMouseNotifications( false );
   lengthKnob.SetPosition( 35, 87 );
   lengthKnob.SetSize( 25, 25 );
   lengthKnob.SetSkin( "Plastic Blue" );
   lengthKnob.SetRange( 0.0, 1.0, 0.5, false, 0 );
   lengthKnob.SetKnobParams( 215, 145 );
   lengthKnob.DisplayValueInPercent( false );
   lengthKnob.SetKnobAdjustsRing( true );

   textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "LENGTH" );
   AddComponent( textLabel12 );
   textLabel12.SetWantsMouseNotifications( false );
   textLabel12.SetPosition( 62, 83 );
   textLabel12.SetSize( 46, 35 );
   textLabel12.SetEditable( false, false );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel12.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel12.SetBorderSize( 1 );
   textLabel12.SetMultiLineEdit( false );
   textLabel12.SetIsNumberEditor( false );
   textLabel12.SetNumberEditorRange( 0, 100 );
   textLabel12.SetNumberEditorInterval( 1 );
   textLabel12.SetNumberEditorUsesMouseWheel( false );
   textLabel12.SetHasCustomTextHoverColor( false );
   textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel12.SetFont( "Arial", 10, true, false );

   textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "INPUT" );
   AddComponent( textLabel14 );
   textLabel14.SetWantsMouseNotifications( false );
   textLabel14.SetPosition( 0, 18 );
   textLabel14.SetSize( 144, 14 );
   textLabel14.SetEditable( false, false );
   textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel14.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel14.SetBkColor( new Color( 107, 113, 6, 255 ) );
   textLabel14.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel14.SetBorderSize( 1 );
   textLabel14.SetMultiLineEdit( false );
   textLabel14.SetIsNumberEditor( false );
   textLabel14.SetNumberEditorRange( 0, 100 );
   textLabel14.SetNumberEditorInterval( 1 );
   textLabel14.SetNumberEditorUsesMouseWheel( false );
   textLabel14.SetHasCustomTextHoverColor( false );
   textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel14.SetFont( "Arial", 10, true, false );

   textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "OUTPUT" );
   AddComponent( textLabel15 );
   textLabel15.SetWantsMouseNotifications( false );
   textLabel15.SetPosition( 0, 329 );
   textLabel15.SetSize( 144, 14 );
   textLabel15.SetEditable( false, false );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel15.SetBkColor( new Color( 107, 113, 6, 255 ) );
   textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel15.SetBorderSize( 1 );
   textLabel15.SetMultiLineEdit( false );
   textLabel15.SetIsNumberEditor( false );
   textLabel15.SetNumberEditorRange( 0, 100 );
   textLabel15.SetNumberEditorInterval( 1 );
   textLabel15.SetNumberEditorUsesMouseWheel( false );
   textLabel15.SetHasCustomTextHoverColor( false );
   textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel15.SetFont( "Arial", 10, true, false );
}



//-------------------------------------------------------------------------------
//  public void Initialize()

//  Initialize will get called shortly after your module's constructor runs. You can use it to
//  do any initialization that the auto-generated code doesn't handle.
//-------------------------------------------------------------------------------
@Override
public void Initialize()
{
   //[user-Initialize]   Add your own initialization code here
   trigger = new Trigger(replayTrigger);

   //[/user-Initialize]
}


//-------------------------------------------------------------------------------
//  public void Destroy()

//  Destroy will get called just before your module gets deleted. You can use it to perform any
//  cleanup that's not handled automatically by Java.
//-------------------------------------------------------------------------------
@Override
public void Destroy()
{
   super.Destroy();
   //[user-Destroy]   Add your own module-getting-deleted code here



   //[/user-Destroy]
}


//-------------------------------------------------------------------------------
//  public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )

//  Notify will get called when various events occur - control values changing, timers firing, etc.
//-------------------------------------------------------------------------------
@Override
public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )
{
   //[user-Notify]   Add your own notification handling code between this line and the notify-close comment
   switch( notification )
   {
      case Knob_Changed:   // doubleValue is the new VoltageKnob value
      {
         if (component == lengthKnob) {
            lengthKnobValue = doubleValue;
         }
         if (component == fadeKnob) {
            fadeKnobValue = doubleValue;
         }
         if (component == widthKnob) {
            widthKnobValue = doubleValue;
         }
         if (component == feedbackKnob) {
            feedbackKnobValue = doubleValue;
            if (!feedbackCvConnected) {
               mixer.setFeedbackLevel(feedbackKnobValue);
            }
         }
         if (component == mixKnob) {
            mixKnobValue = doubleValue;
            if (!mixCvConnected) {
               mixer.setMixLevel(mixKnobValue);
            }
         }
      }
      break;
   
      case Slider_Changed:   // doubleValue is the new slider value
      {
      }
      break;
   
      case Button_Changed:   // doubleValue is the new button/toggle button value
      {
      }
      break;
   
      case Switch_Changed:   // doubleValue is the new switch value
      {
      }
      break;
   
      case Jack_Connected:   // longValue is the new cable ID
      {
         if (component == lengthCv) {
            lengthCvConnected = true;
         }
         if (component == fadeCv) {
            fadeCvConnected = true;
         }
         if (component == widthCv) {
            widthCvConnected = true;
         }
         if (component == feedbackCv) {
            feedbackCvConnected = true;
         }
         if (component == mixCv) {
            mixCvConnected = true;
         }
      }
      break;
   
      case Jack_Disconnected:   // All cables have been disconnected from this jack
      {
         if (component == lengthCv) {
            lengthCvConnected = false;
         }
         if (component == fadeCv) {
            fadeCvConnected = false;
         }
         if (component == widthCv) {
            widthCvConnected = false;
         }
         if (component == feedbackCv) {
            feedbackCvConnected = false;
            mixer.setFeedbackLevel(feedbackKnob.GetValue());
         }
         if (component == mixCv) {
            mixCvConnected = false;
            mixer.setMixLevel(mixKnob.GetValue());
         }
      }
      break;
   
      case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
      {
      }
      break;
   
      case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_RightButtonDown:   // called when user releases right mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_RightButtonUp:   // called when user right-clicks on an object that receives mouse notifications
      {
      }
      break;
   
      case Object_LeftButtonDoubleClick: // called when user left-button double-clicks on an object that receives mouse notifications
      {
      }
      break;
   
      // Less common notifications:
   
      case Named_Timer:   // object contains a String with the name of the timer that has fired
      {
      }
      break;
   
      case Canvas_Painting:   // About to paint canvas.  object is a java.awt.Rectangle with painting boundaries
      {
      }
      break;
   
      case Canvas_Painted:   // Canvas painting is complete
      {
      }
      break;
   
      case Control_DragStart:    // A user has started dragging on a control that has been marked as draggable
      {
      }
      break;
   
      case Control_DragOn:       // This control has been dragged over during a drag operation. object contains the dragged object
      {
      }
      break;
   
      case Control_DragOff:      // This control has been dragged over during a drag operation. object contains the dragged object
      {
      }
      break;
   
      case Control_DragEnd:      // A user has ended their drag on a control that has been marked as draggable
      {
      }
      break;
   
      case Label_Changed:        // The text of an editable text control has changed
      {
      }
      break;
   
      case SoundPlayback_Start:   // A sound has begun playback
      {
      }
      break;
   
      case SoundPlayback_End:     // A sound has ended playback
      {
      }
      break;
   
      case Scrollbar_Position:    // longValue is the new scrollbar position
      {
      }
      break;
   
      case PolyVoices_Changed:    // longValue is the new number of poly voices
      {
      }
      break;
   
      case File_Dropped:     // 'object' is a String containing the file path
      {
      }
      break;
   
      case Preset_Loading_Start:   // called when preset loading begins
      {
      }
      break;
   
      case Preset_Loading_Finish:  // called when preset loading finishes
      {
      }
      break;
   
      case Variation_Loading_Start:    // sent when a variation is about to load
      {
      }
      break;
   
      case Variation_Loading_Finish:   // sent when a variation has just finished loading
      {
      }
      break;
   
      case Tempo_Changed:     // doubleValue is the new tempo
      {
      }
      break;
   
      case Randomized:     // called when the module's controls get randomized
      {
      }
      break;
   
      case VariationListChanged:   // sent when a variation gets added, deleted, or renamed, or the variations list gets reordered
      {
      }
      break;
   
      case Key_Press:     // sent when module has keyboard focus and a key is pressed; object is a VoltageKeyPressInfo object
      {
      }
      break;
   
      case Reset:    // sent when the module has been reset to default settings
      {
      }
      break;
   
      case Keyboard_NoteOn:   // sent when a note has been pressed on a VoltageKeyboard object. longValue is the note value ( 0-127 )
      {
      }
      break;
   
      case Keyboard_NoteOff:   // sent when a note has been released on a VoltageKeyboard object. longValue is the note value ( 0-127 )
      {
      }
      break;
   
      case Curve_Changed:   // sent when user has edited a curve's value. 'object' will be a VoltageCurve.CurveChangeNotification object.
      {
      }
      break;
   }



   return false;
   //[/user-Notify]
}


//-------------------------------------------------------------------------------
//  public void ProcessSample()

//  ProcessSample is called once per sample. Usually it's where you read
//  from input jacks, process audio, and write it to your output jacks.
//  Since ProcesssSample gets called 48,000 times per second, offload CPU-intensive operations
//  to other threads when possible and avoid calling native functions.
//-------------------------------------------------------------------------------
@Override
public void ProcessSample()
{
   //[user-ProcessSample]   Add your own process-sampling code here

   // Get the inputs
   double leftSample = inputLeft.GetValue();
   double rightSample = rightIsConnected ? inputRight.GetValue() : leftSample;
   
   if (mixCvConnected) {
      mixer.setMixLevel(scale(mixKnobValue, mixCv));
   }
   
   if (feedbackCvConnected) {
      mixer.setFeedbackLevel(scale(feedbackKnobValue, feedbackCv));
   }

   // Write the dry inputs into the mixer
   mixer.writeDry(leftSample, rightSample);
   
   // Write the replays into the mixer
   replayers.processSample(mixer);
   
   // Write the mixer contents to the buffer and outputs
   int bufferSize = mixer.processSample(buffer, outputLeft, outputRight);
   
   // Nothing to do unless the trigger is fired
   if (!trigger.hasFired()) {
      return;
   }
   
   // Create a new replay
   int offset = (int) (Values.FastRandom() * bufferSize);
   double lengthMult = 0.1
      + (0.9 * Values.FastRandomInclusive() 
         * (lengthCvConnected ? scale(lengthKnobValue, lengthCv) : lengthKnobValue)
      );
   int length = (int) (lengthMult * 192000.0);
   int fadeLength = 200 + (int) ((length - 200.0)
      * 0.5
      * (fadeCvConnected
         ? scale(fadeKnobValue, fadeCv)
         : fadeKnobValue));
   double panAmount = widthCvConnected ? scale(widthKnobValue, widthCv) : widthKnobValue;
   double pan = ((Values.FastRandomInclusive() - 0.5) * panAmount)+ 0.5;
   Replayer replayer = buffer.getReplayer(pan, offset, length, fadeLength);
   int replayCount = replayers.add(replayer);
   //[/user-ProcessSample]
}


//-------------------------------------------------------------------------------
//  public String GetTooltipText( VoltageComponent component )

//  Gets called when a tooltip is about to display for a control. Override it if
//  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
//  for instance, you can translate the knob's current value to a log-based string and display it here.
//-------------------------------------------------------------------------------
@Override
public String GetTooltipText( VoltageComponent component )
{
   //[user-GetTooltipText]   Add your own code here



   return super.GetTooltipText( component );
   //[/user-GetTooltipText]
}


//-------------------------------------------------------------------------------
//  public void EditComponentValue( VoltageComponent component, double newValue, String newText )

//  Gets called after a user clicks on a tooltip and types in a new value for a control. Override this if
//  you've changed the default tooltip display (translating a linear value to logarithmic, for instance)
//  in GetTooltipText().
//-------------------------------------------------------------------------------
@Override
public void EditComponentValue( VoltageComponent component, double newValue, String newText )
{
   //[user-EditComponentValue]   Add your own code here



   //[/user-EditComponentValue]
   super.EditComponentValue( component, newValue, newText );
}


//-------------------------------------------------------------------------------
//  public void OnUndoRedo( String undoType, double newValue, Object optionalObject )

//  If you've created custom undo events via calls to CreateUndoEvent, you'll need to
//  process them in this function when they get triggered by undo/redo actions.
//-------------------------------------------------------------------------------
@Override
public void OnUndoRedo( String undoType, double newValue, Object optionalObject )
{
   //[user-OnUndoRedo]   Add your own code here



   //[/user-OnUndoRedo]
}


//-------------------------------------------------------------------------------
//  public byte[] GetStateInformation()

//  Gets called when the module's state gets saved, typically when the user saves a preset with
//  this module in it. Voltage Modular will automatically save the states of knobs, sliders, etc.,
//  but if you have any custom state information you need to save, return it from this function.
//-------------------------------------------------------------------------------
@Override
public byte[] GetStateInformation()
{
   //[user-GetStateInformation]   Add your own code here



   return null;
   //[/user-GetStateInformation]
}


//-------------------------------------------------------------------------------
//  public void SetStateInformation(byte[] stateInfo)

//  Gets called when this module's state is getting restored, typically when a user opens a preset with
//  this module in it. The stateInfo parameter will contain whatever custom data you stored in GetStateInformation().
//-------------------------------------------------------------------------------
@Override
public void SetStateInformation(byte[] stateInfo)
{
   //[user-SetStateInformation]   Add your own code here



   //[/user-SetStateInformation]
}


//-------------------------------------------------------------------------------
//  public byte[] GetStateInformationForVariations()

//  Gets called when a user saves a variation with this module in it.
//  Voltage Modular will automatically save the states of knobs, sliders, etc.,
//  but if you have any custom state information you need to save, return it from this function.
//-------------------------------------------------------------------------------
@Override
public byte[] GetStateInformationForVariations()
{
   //[user-GetStateInformationForVariations]   Add your own code here



   return GetStateInformation();
   //[/user-GetStateInformationForVariations]
}


//-------------------------------------------------------------------------------
//  public void SetStateInformationForVariations(byte[] stateInfo)

//  Gets called when a user loads a variation with this module in it.
//  The stateInfo parameter will contain whatever custom data you stored in GetStateInformationForVariations().
//-------------------------------------------------------------------------------
@Override
public void SetStateInformationForVariations(byte[] stateInfo)
{
   //[user-SetStateInformationForVariations]   Add your own code here
   SetStateInformation(stateInfo);



   //[/user-SetStateInformationForVariations]
}


// Auto-generated variables
private VoltageLabel textLabel15;
private VoltageLabel textLabel14;
private VoltageLabel textLabel12;
private VoltageKnob lengthKnob;
private VoltageAudioJack lengthCv;
private VoltageLabel textLabel11;
private VoltageKnob fadeKnob;
private VoltageAudioJack fadeCv;
private VoltageLabel textLabel10;
private VoltageKnob widthKnob;
private VoltageAudioJack widthCv;
private VoltageLabel textLabel9;
private VoltageKnob feedbackKnob;
private VoltageAudioJack feedbackCv;
private VoltageLabel textLabel8;
private VoltageKnob mixKnob;
private VoltageAudioJack mixCv;
private VoltageAudioJack outputLeft;
private VoltageAudioJack outputRight;
private VoltageLabel textLabel7;
private VoltageAudioJack replayTrigger;
private VoltageLabel textLabel5;
private VoltageLabel textLabel4;
private VoltageAudioJack inputRight;
private VoltageLabel textLabel3;
private VoltageLabel textLabel2;
private VoltageLabel textLabel6;
private VoltageLabel textLabel1;
private VoltageAudioJack inputLeft;


//[user-code-and-variables]    Add your own variables and functions here
private boolean rightIsConnected = false;
private Trigger trigger;

private RollingBuffer buffer = new RollingBuffer(48000 * 4);
private ReplayStack replayers = new ReplayStack(16);
private Mixer mixer = new Mixer();

private double lengthKnobValue = 0.5;
private double fadeKnobValue = 0.5;
private double widthKnobValue = 0.0;
private double feedbackKnobValue = 0.0;
private double mixKnobValue = 0.3;
private boolean lengthCvConnected = false;
private boolean fadeCvConnected = false;
private boolean widthCvConnected = false;
private boolean feedbackCvConnected = false;
private boolean mixCvConnected = false;

private static class RollingBuffer {

   private final int size;
   private final double[] leftBuffer;
   private final double[] rightBuffer;
   private int ptr;
   private boolean isFull = false;
   
   public RollingBuffer(int size) {
      this.size = size;
      this.leftBuffer = new double[size];
      this.rightBuffer = new double[size];
   }
   
   public int write(double left, double right) {
      leftBuffer[ptr] = left;
      rightBuffer[ptr] = right;
      
      ptr = ptr + 1;
      if (ptr == size) {
         ptr = 0;
         isFull = true;
      }
      
      return isFull ? size : ptr;
   }
   
   public void clear() {
      ptr = 0;
      isFull = false;
   }

   public Replayer getReplayer(double pan, int offset, int length, int fadeSize) {
      int start = (ptr + size - offset) % size;
      int end = (start + length) % size;
      return new Replayer(leftBuffer, rightBuffer, pan, size, start, end, fadeSize);
   }

}

private static class Replayer {

   private final double[] leftBuffer;
   private final double[] rightBuffer;
   private final double leftPan;
   private final double rightPan;
   private final int size;
   private final int start;
   private final int end;
   private final int fadeInEnd;
   private final int fadeOutStart;
   private final int sampleLength;
   private int ptr;;
   private int fadeCount = 0;
   private double fadePtr = 0.0;
   private double fadeDelta;
   
   public Replayer(double[] leftBuffer, double[] rightBuffer, double pan, int size, int start, int end, int fadeSize) {
      this.leftBuffer = leftBuffer;
      this.rightBuffer = rightBuffer;
      this.leftPan = Math.cos(pan * Values.HALF_PI);
      this.rightPan = Math.sin(pan * Values.HALF_PI);
      this.size = size;
      this.start = start;
      this.ptr = start;
      this.end = end;
      this.fadeInEnd = fadeSize;
      this.sampleLength = (end + size - start) % size;
      this.fadeOutStart = this.sampleLength - fadeSize;
      this.fadeDelta = 1.0 / (double) fadeInEnd;
   }
   
   public boolean processSample(Mixer mixer) {
      double leftSample = leftBuffer[ptr] * leftPan;
      double rightSample = rightBuffer[ptr] * rightPan;
      
      // Handle fading in and out
      if (fadeCount < fadeInEnd) {
         double squared = fadePtr * fadePtr;
         double cubed = squared * fadePtr;
         double fadeAmount = squared + squared + squared - (cubed + cubed);
         fadePtr += fadeDelta;
         leftSample *= fadeAmount;
         rightSample *= fadeAmount;
      }
      
      if (fadeCount == fadeOutStart) {
         fadePtr = 1.0;
      }
      
      if (fadeCount >= fadeOutStart) {
         double squared = fadePtr * fadePtr;
         double cubed = squared * fadePtr;
         double fadeAmount = squared + squared + squared - (cubed + cubed);
         fadePtr -= fadeDelta;
         leftSample *= fadeAmount;
         rightSample *= fadeAmount;
      }
      fadeCount++;
      
      mixer.writeReplay(leftSample, rightSample);
      ptr += 1;
      if (ptr == size) {
         ptr = 0;
      }
      
      return ptr == end;
   }

}

private static class Trigger {

   private final VoltageAudioJack jack;
   private boolean wasTriggering;
   
   public Trigger(VoltageAudioJack jack) {
      this.jack = jack;
   }
   
   public boolean hasFired() {
      boolean isTriggering = jack.GetValue() >= 5.0;
      if (isTriggering &! wasTriggering) {
         wasTriggering = true;
         return true;
      }
      wasTriggering = isTriggering;
      return false;
   }
}

private static class ReplayNode {

   public final Replayer replayer;
   public ReplayNode previous;
   public ReplayNode next;
   
   public ReplayNode(Replayer replayer, ReplayNode previous, ReplayNode next) {
      this.replayer = replayer;
      this.previous = previous;
      this.next = next;
   }
   
   public void remove() {
      if (previous != null) {
         previous.next = next;
      }
      if (next != null) {
         next.previous = previous;
      }
   }

}

private static class ReplayStack {

   private final int maxSize;
   private ReplayNode first;
   private ReplayNode last;
   private int count;
   
   public ReplayStack(int maxSize) {
      this.maxSize = maxSize;
   }
   
   public int add(Replayer replayer) {
      if (count == maxSize) {
         return count;
      }
      if (first == null) {
         first = new ReplayNode(replayer, null, null);
         last = first;
      } else {
         last.next = new ReplayNode(replayer, last, null);
         last = last.next;
      }
      count++;
      return count;
   }
   
   public void processSample(Mixer mixer) {
      mixer.startReplayWrites();
      if (first == null) {
         return;
      }
      
      ReplayNode current = first;
      while (current != null) {
         boolean complete = current.replayer.processSample(mixer);
         if (complete) {
            if (current == first) {
               first = current.next;
            }
            if (current == last) {
               last = current.previous;
            }
            ReplayNode newCurrent = current.next;
            current.remove();
            current = newCurrent;
            count--;
         } else {
            current = current.next;
         }
      }
   }
}

private static class Mixer {

   private double dryLeft;
   private double dryRight;
   
   private double replaysLeft;
   private double replaysRight;
   
   private final SmoothValue feedbackLevel = new SmoothValue(0.2);
   private final SmoothValue mixLevel = new SmoothValue(0.5);
   private final Limiter limiter = new Limiter();
   
   public void writeDry(double dryLeft, double dryRight) {
      this.dryLeft = dryLeft;
      this.dryRight = dryRight;
      limiter.SetReleaseTime(200);
   }
   
   public void setFeedbackLevel(double targetLevel) {
      feedbackLevel.SetValue(targetLevel);
   }
   
   public void setMixLevel(double targetLevel) {
      mixLevel.SetValue(targetLevel);
   }
   
   public void startReplayWrites() {
      replaysLeft = 0.0;
      replaysRight = 0.0;
   }
   
   public void writeReplay(double replayLeft, double replayRight) {
      replaysLeft += replayLeft;
      replaysRight += replayRight;
   }
   
   public int processSample(RollingBuffer buffer, VoltageAudioJack leftOut, VoltageAudioJack rightOut) {
      double feedbackLevelValue = feedbackLevel.GetValue();
      
      // Limit the replays
      double[] toLimit = new double[] { replaysLeft, replaysRight };
      limiter.ProcessSample(toLimit);
      
      double limitedReplaysLeft = toLimit[0];
      double limitedReplaysRight = toLimit[1];
      
      // Populate the buffer
      double bufferLeft = dryLeft + (feedbackLevelValue * limitedReplaysLeft);
      double bufferRight = dryRight + (feedbackLevelValue * limitedReplaysRight);
      int bufferSize = buffer.write(bufferLeft, bufferRight);
      
      // Mix replays and dry signal
      double mixLevelValue = mixLevel.GetValue();
      double inverse = 1.0 - mixLevelValue;
      leftOut.SetValue((dryLeft * inverse) + (limitedReplaysLeft * mixLevelValue));
      rightOut.SetValue((dryRight * inverse) + (limitedReplaysRight * mixLevelValue));
      
      return bufferSize;
   }
}

   private double scale(double knobValue, VoltageAudioJack cv) {
      double cvValue = Math.min(1.0, Math.max(0, cv.GetValue() + 0.5));
      return knobValue * cvValue;
   }
//[/user-code-and-variables]
}

 