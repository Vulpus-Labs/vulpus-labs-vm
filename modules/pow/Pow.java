package com.vulpuslabs.pow;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import java.awt.geom.GeneralPath;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.util.function.Consumer;
//[/user-imports]


public class Pow extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

@SuppressWarnings("this-escape") 
public Pow( long moduleID, VoltageObjects voltageObjects )
{
   super( moduleID, voltageObjects, "Pow", ModuleType.ModuleType_CVProcessors, 2.0 );

   InitializeControls();


   canBeBypassed = false;
   SetSkin( "5a0222df120542e98998f690677f275b" );
}

void InitializeControls()
{

   inputJackL = new VoltageAudioJack( "inputJackL", "Left Input", this, JackType.JackType_AudioInput );
   AddComponent( inputJackL );
   inputJackL.SetWantsMouseNotifications( false );
   inputJackL.SetPosition( 17, 29 );
   inputJackL.SetSize( 25, 25 );
   inputJackL.SetSkin( "Jack Round Clay Ring" );

   outputJackL = new VoltageAudioJack( "outputJackL", "Left Output", this, JackType.JackType_AudioOutput );
   AddComponent( outputJackL );
   outputJackL.SetWantsMouseNotifications( false );
   outputJackL.SetPosition( 17, 314 );
   outputJackL.SetSize( 25, 25 );
   outputJackL.SetSkin( "Jack Round Marine Blue Ring" );

   midpointXKnob = new VoltageKnob( "midpointXKnob", "Midpoint X", this, 0.001, 0.999, 0.5 );
   AddComponent( midpointXKnob );
   midpointXKnob.SetWantsMouseNotifications( false );
   midpointXKnob.SetPosition( 35, 212 );
   midpointXKnob.SetSize( 27, 27 );
   midpointXKnob.SetSkin( "Plastic Dark Blue" );
   midpointXKnob.SetRange( 0.001, 0.999, 0.5, false, 0 );
   midpointXKnob.SetKnobParams( 215, 145 );
   midpointXKnob.DisplayValueInPercent( false );
   midpointXKnob.SetKnobAdjustsRing( true );

   midpointYKnob = new VoltageKnob( "midpointYKnob", "Midpoint Y", this, 0.001, 0.999, 0.5 );
   AddComponent( midpointYKnob );
   midpointYKnob.SetWantsMouseNotifications( false );
   midpointYKnob.SetPosition( 35, 243 );
   midpointYKnob.SetSize( 27, 27 );
   midpointYKnob.SetSkin( "Plastic Blue" );
   midpointYKnob.SetRange( 0.001, 0.999, 0.5, false, 0 );
   midpointYKnob.SetKnobParams( 215, 145 );
   midpointYKnob.DisplayValueInPercent( false );
   midpointYKnob.SetKnobAdjustsRing( true );

   invertSwitch = new VoltageSwitch( "invertSwitch", "Rectification", this, 0 );
   AddComponent( invertSwitch );
   invertSwitch.SetWantsMouseNotifications( false );
   invertSwitch.SetPosition( 22, 267 );
   invertSwitch.SetSize( 35, 35 );
   invertSwitch.SetSkin( "3-State Red Cap Horizontal" );

   graphCanvas = new VoltageCanvas( "graphCanvas", "Graph", this, 100, 100 );
   AddComponent( graphCanvas );
   graphCanvas.SetWantsMouseNotifications( true );
   graphCanvas.SetHighDensity( true );
   graphCanvas.SetPosition( 24, 72 );
   graphCanvas.SetSize( 100, 100 );

   midpointXModAmountKnob = new VoltageKnob( "midpointXModAmountKnob", "Midpoint X Mod Amount", this, -1, 1.0, 0 );
   AddComponent( midpointXModAmountKnob );
   midpointXModAmountKnob.SetWantsMouseNotifications( false );
   midpointXModAmountKnob.SetPosition( 71, 212 );
   midpointXModAmountKnob.SetSize( 25, 25 );
   midpointXModAmountKnob.SetSkin( "ARP2500 Sm Red" );
   midpointXModAmountKnob.SetRange( -1, 1.0, 0, false, 0 );
   midpointXModAmountKnob.SetKnobParams( 215, 145 );
   midpointXModAmountKnob.DisplayValueInPercent( false );
   midpointXModAmountKnob.SetKnobAdjustsRing( true );

   midpointXModJack = new VoltageAudioJack( "midpointXModJack", "Midpoint X Mod", this, JackType.JackType_AudioInput );
   AddComponent( midpointXModJack );
   midpointXModJack.SetWantsMouseNotifications( false );
   midpointXModJack.SetPosition( 106, 212 );
   midpointXModJack.SetSize( 25, 25 );
   midpointXModJack.SetSkin( "Jack Round Clay Ring" );

   midpointYModAmountKnob = new VoltageKnob( "midpointYModAmountKnob", "Midpoint Y Mod Amount", this, -1, 1.0, 0 );
   AddComponent( midpointYModAmountKnob );
   midpointYModAmountKnob.SetWantsMouseNotifications( false );
   midpointYModAmountKnob.SetPosition( 71, 243 );
   midpointYModAmountKnob.SetSize( 25, 25 );
   midpointYModAmountKnob.SetSkin( "ARP2500 Sm Red" );
   midpointYModAmountKnob.SetRange( -1, 1.0, 0, false, 0 );
   midpointYModAmountKnob.SetKnobParams( 215, 145 );
   midpointYModAmountKnob.DisplayValueInPercent( false );
   midpointYModAmountKnob.SetKnobAdjustsRing( true );

   midpointYModJack = new VoltageAudioJack( "midpointYModJack", "Midpoint Y Mod", this, JackType.JackType_AudioInput );
   AddComponent( midpointYModJack );
   midpointYModJack.SetWantsMouseNotifications( false );
   midpointYModJack.SetPosition( 106, 243 );
   midpointYModJack.SetSize( 25, 25 );
   midpointYModJack.SetSkin( "Jack Round Clay Ring" );

   textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "POW!" );
   AddComponent( textLabel1 );
   textLabel1.SetWantsMouseNotifications( false );
   textLabel1.SetPosition( -1, 0 );
   textLabel1.SetSize( 145, 15 );
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

   polyInputJack = new VoltagePolyJack( "polyInputJack", "Poly Input", this, JackType.JackType_PolyInput );
   AddComponent( polyInputJack );
   polyInputJack.SetWantsMouseNotifications( false );
   polyInputJack.SetPosition( 87, 29 );
   polyInputJack.SetSize( 25, 25 );
   polyInputJack.SetSkin( "Poly Jack Straight" );

   polyOutputJack = new VoltagePolyJack( "polyOutputJack", "Poly Output", this, JackType.JackType_PolyOutput );
   AddComponent( polyOutputJack );
   polyOutputJack.SetWantsMouseNotifications( false );
   polyOutputJack.SetPosition( 87, 315 );
   polyOutputJack.SetSize( 25, 25 );
   polyOutputJack.SetSkin( "Poly Jack Straight" );

   textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "VULPUS LABS" );
   AddComponent( textLabel2 );
   textLabel2.SetWantsMouseNotifications( false );
   textLabel2.SetPosition( -1, 345 );
   textLabel2.SetSize( 145, 15 );
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

   textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "POLY" );
   AddComponent( textLabel4 );
   textLabel4.SetWantsMouseNotifications( false );
   textLabel4.SetPosition( 115, 29 );
   textLabel4.SetSize( 29, 24 );
   textLabel4.SetEditable( false, false );
   textLabel4.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel4.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel4.SetBorderSize( 1 );
   textLabel4.SetMultiLineEdit( true );
   textLabel4.SetIsNumberEditor( false );
   textLabel4.SetNumberEditorRange( 0, 100 );
   textLabel4.SetNumberEditorInterval( 1 );
   textLabel4.SetNumberEditorUsesMouseWheel( false );
   textLabel4.SetHasCustomTextHoverColor( false );
   textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel4.SetFont( "Arial", 10, true, false );

   textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "L" );
   AddComponent( textLabel5 );
   textLabel5.SetWantsMouseNotifications( false );
   textLabel5.SetPosition( 6, 327 );
   textLabel5.SetSize( 15, 15 );
   textLabel5.SetEditable( false, false );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel5.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel5.SetBorderSize( 1 );
   textLabel5.SetMultiLineEdit( true );
   textLabel5.SetIsNumberEditor( false );
   textLabel5.SetNumberEditorRange( 0, 100 );
   textLabel5.SetNumberEditorInterval( 1 );
   textLabel5.SetNumberEditorUsesMouseWheel( false );
   textLabel5.SetHasCustomTextHoverColor( false );
   textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel5.SetFont( "Arial", 10, true, false );

   textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "POLY" );
   AddComponent( textLabel6 );
   textLabel6.SetWantsMouseNotifications( false );
   textLabel6.SetPosition( 115, 315 );
   textLabel6.SetSize( 27, 24 );
   textLabel6.SetEditable( false, false );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel6.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel6.SetBorderSize( 1 );
   textLabel6.SetMultiLineEdit( true );
   textLabel6.SetIsNumberEditor( false );
   textLabel6.SetNumberEditorRange( 0, 100 );
   textLabel6.SetNumberEditorInterval( 1 );
   textLabel6.SetNumberEditorUsesMouseWheel( false );
   textLabel6.SetHasCustomTextHoverColor( false );
   textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel6.SetFont( "Arial", 10, true, false );

   textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "MID POINT" );
   AddComponent( textLabel7 );
   textLabel7.SetWantsMouseNotifications( false );
   textLabel7.SetPosition( 35, 184 );
   textLabel7.SetSize( 40, 24 );
   textLabel7.SetEditable( false, false );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel7.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel7.SetBorderSize( 1 );
   textLabel7.SetMultiLineEdit( true );
   textLabel7.SetIsNumberEditor( false );
   textLabel7.SetNumberEditorRange( 0, 100 );
   textLabel7.SetNumberEditorInterval( 1 );
   textLabel7.SetNumberEditorUsesMouseWheel( false );
   textLabel7.SetHasCustomTextHoverColor( false );
   textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel7.SetFont( "Arial", 10, true, false );

   textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "MOD AMT" );
   AddComponent( textLabel8 );
   textLabel8.SetWantsMouseNotifications( false );
   textLabel8.SetPosition( 71, 184 );
   textLabel8.SetSize( 37, 24 );
   textLabel8.SetEditable( false, false );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel8.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel8.SetBorderSize( 1 );
   textLabel8.SetMultiLineEdit( true );
   textLabel8.SetIsNumberEditor( false );
   textLabel8.SetNumberEditorRange( 0, 100 );
   textLabel8.SetNumberEditorInterval( 1 );
   textLabel8.SetNumberEditorUsesMouseWheel( false );
   textLabel8.SetHasCustomTextHoverColor( false );
   textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel8.SetFont( "Arial", 10, true, false );

   textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "MOD IN" );
   AddComponent( textLabel9 );
   textLabel9.SetWantsMouseNotifications( false );
   textLabel9.SetPosition( 108, 184 );
   textLabel9.SetSize( 32, 24 );
   textLabel9.SetEditable( false, false );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel9.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel9.SetBorderSize( 1 );
   textLabel9.SetMultiLineEdit( true );
   textLabel9.SetIsNumberEditor( false );
   textLabel9.SetNumberEditorRange( 0, 100 );
   textLabel9.SetNumberEditorInterval( 1 );
   textLabel9.SetNumberEditorUsesMouseWheel( false );
   textLabel9.SetHasCustomTextHoverColor( false );
   textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel9.SetFont( "Arial", 10, true, false );

   textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "X" );
   AddComponent( textLabel10 );
   textLabel10.SetWantsMouseNotifications( false );
   textLabel10.SetPosition( 0, 212 );
   textLabel10.SetSize( 26, 24 );
   textLabel10.SetEditable( false, false );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.Right );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel10.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel10.SetBorderSize( 1 );
   textLabel10.SetMultiLineEdit( true );
   textLabel10.SetIsNumberEditor( false );
   textLabel10.SetNumberEditorRange( 0, 100 );
   textLabel10.SetNumberEditorInterval( 1 );
   textLabel10.SetNumberEditorUsesMouseWheel( false );
   textLabel10.SetHasCustomTextHoverColor( false );
   textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel10.SetFont( "Arial", 10, true, false );

   textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "Y" );
   AddComponent( textLabel11 );
   textLabel11.SetWantsMouseNotifications( false );
   textLabel11.SetPosition( 0, 243 );
   textLabel11.SetSize( 26, 24 );
   textLabel11.SetEditable( false, false );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.Right );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel11.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel11.SetBorderSize( 1 );
   textLabel11.SetMultiLineEdit( true );
   textLabel11.SetIsNumberEditor( false );
   textLabel11.SetNumberEditorRange( 0, 100 );
   textLabel11.SetNumberEditorInterval( 1 );
   textLabel11.SetNumberEditorUsesMouseWheel( false );
   textLabel11.SetHasCustomTextHoverColor( false );
   textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel11.SetFont( "Arial", 10, true, false );

   textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "RECTIFICATION" );
   AddComponent( textLabel12 );
   textLabel12.SetWantsMouseNotifications( false );
   textLabel12.SetPosition( 57, 272 );
   textLabel12.SetSize( 71, 24 );
   textLabel12.SetEditable( false, false );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel12.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel12.SetBorderSize( 1 );
   textLabel12.SetMultiLineEdit( true );
   textLabel12.SetIsNumberEditor( false );
   textLabel12.SetNumberEditorRange( 0, 100 );
   textLabel12.SetNumberEditorInterval( 1 );
   textLabel12.SetNumberEditorUsesMouseWheel( false );
   textLabel12.SetHasCustomTextHoverColor( false );
   textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel12.SetFont( "Arial", 10, true, false );

   inputJackR = new VoltageAudioJack( "inputJackR", "Right Input", this, JackType.JackType_AudioInput );
   AddComponent( inputJackR );
   inputJackR.SetWantsMouseNotifications( false );
   inputJackR.SetPosition( 46, 29 );
   inputJackR.SetSize( 25, 25 );
   inputJackR.SetSkin( "Jack Round Clay Ring" );

   outputJackR = new VoltageAudioJack( "outputJackR", "Right Output", this, JackType.JackType_AudioOutput );
   AddComponent( outputJackR );
   outputJackR.SetWantsMouseNotifications( false );
   outputJackR.SetPosition( 46, 314 );
   outputJackR.SetSize( 25, 25 );
   outputJackR.SetSkin( "Jack Round Marine Blue Ring" );

   textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "R" );
   AddComponent( textLabel14 );
   textLabel14.SetWantsMouseNotifications( false );
   textLabel14.SetPosition( 70, 327 );
   textLabel14.SetSize( 15, 15 );
   textLabel14.SetEditable( false, false );
   textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel14.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel14.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel14.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel14.SetBorderSize( 1 );
   textLabel14.SetMultiLineEdit( true );
   textLabel14.SetIsNumberEditor( false );
   textLabel14.SetNumberEditorRange( 0, 100 );
   textLabel14.SetNumberEditorInterval( 1 );
   textLabel14.SetNumberEditorUsesMouseWheel( false );
   textLabel14.SetHasCustomTextHoverColor( false );
   textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel14.SetFont( "Arial", 10, true, false );

   textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "OUT" );
   AddComponent( textLabel15 );
   textLabel15.SetWantsMouseNotifications( false );
   textLabel15.SetPosition( 2, 298 );
   textLabel15.SetSize( 140, 15 );
   textLabel15.SetEditable( false, false );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel15.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel15.SetBorderSize( 1 );
   textLabel15.SetMultiLineEdit( true );
   textLabel15.SetIsNumberEditor( false );
   textLabel15.SetNumberEditorRange( 0, 100 );
   textLabel15.SetNumberEditorInterval( 1 );
   textLabel15.SetNumberEditorUsesMouseWheel( false );
   textLabel15.SetHasCustomTextHoverColor( false );
   textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel15.SetFont( "Arial", 10, true, true );

   textLabel17 = new VoltageLabel( "textLabel17", "textLabel17", this, "IN" );
   AddComponent( textLabel17 );
   textLabel17.SetWantsMouseNotifications( false );
   textLabel17.SetPosition( 4, 14 );
   textLabel17.SetSize( 140, 15 );
   textLabel17.SetEditable( false, false );
   textLabel17.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel17.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel17.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel17.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel17.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel17.SetBorderSize( 1 );
   textLabel17.SetMultiLineEdit( true );
   textLabel17.SetIsNumberEditor( false );
   textLabel17.SetNumberEditorRange( 0, 100 );
   textLabel17.SetNumberEditorInterval( 1 );
   textLabel17.SetNumberEditorUsesMouseWheel( false );
   textLabel17.SetHasCustomTextHoverColor( false );
   textLabel17.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel17.SetFont( "Arial", 10, true, true );

   textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "L" );
   AddComponent( textLabel13 );
   textLabel13.SetWantsMouseNotifications( false );
   textLabel13.SetPosition( 6, 42 );
   textLabel13.SetSize( 15, 15 );
   textLabel13.SetEditable( false, false );
   textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel13.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel13.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel13.SetBorderSize( 1 );
   textLabel13.SetMultiLineEdit( true );
   textLabel13.SetIsNumberEditor( false );
   textLabel13.SetNumberEditorRange( 0, 100 );
   textLabel13.SetNumberEditorInterval( 1 );
   textLabel13.SetNumberEditorUsesMouseWheel( false );
   textLabel13.SetHasCustomTextHoverColor( false );
   textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel13.SetFont( "Arial", 10, true, false );

   textLabel16 = new VoltageLabel( "textLabel16", "textLabel16", this, "R" );
   AddComponent( textLabel16 );
   textLabel16.SetWantsMouseNotifications( false );
   textLabel16.SetPosition( 70, 42 );
   textLabel16.SetSize( 15, 15 );
   textLabel16.SetEditable( false, false );
   textLabel16.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel16.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel16.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel16.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel16.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel16.SetBorderSize( 1 );
   textLabel16.SetMultiLineEdit( true );
   textLabel16.SetIsNumberEditor( false );
   textLabel16.SetNumberEditorRange( 0, 100 );
   textLabel16.SetNumberEditorInterval( 1 );
   textLabel16.SetNumberEditorUsesMouseWheel( false );
   textLabel16.SetHasCustomTextHoverColor( false );
   textLabel16.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel16.SetFont( "Arial", 10, true, false );
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
   polyVoiceCount = GetNumberOfPolyVoices();
   StartGuiUpdateTimer();


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
         if (component==midpointXKnob) {
             targetMidpointX = doubleValue;
         } else if (component==midpointYKnob) {
             targetMidpointY = doubleValue;
         } else if (component==midpointXModAmountKnob) {
             midpointXModAmount = doubleValue;
         } else if (component==midpointYModAmountKnob) {
             midpointYModAmount = doubleValue;
         }
         smoothing = true;
         calculateExponent();
         graphCanvas.Invalidate();
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
          rectification = Rectification.of(doubleValue);
      }
      break;
   
      case Jack_Connected:   // longValue is the new cable ID
      {
         modding = midpointXModJack.IsConnected() || midpointYModJack.IsConnected();
         processPoly = polyInputJack.IsConnected() && polyOutputJack.IsConnected();
      }
      break;
   
      case Jack_Disconnected:   // All cables have been disconnected from this jack
      {
         modding = midpointXModJack.IsConnected() || midpointYModJack.IsConnected();
         processPoly = polyInputJack.IsConnected() && polyOutputJack.IsConnected();
         if (!modding) {
            calculateExponent();
            graphCanvas.Invalidate();
         }
      }
      break;
   
      case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
      {
          if (modding || smoothing) graphCanvas.Invalidate();
      }
      break;
   
      case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
         if (component == graphCanvas) {
            if (dragging) {
               SetMouseCursor(MouseCursorTypes.DraggingHand);
               moveMidpoint(x, y);
            } else {
               SetMouseCursor(MouseCursorTypes.PointingHand);
            }
         }
      }
      break;
   
      case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
         if (component == graphCanvas) {
            dragging = false;
            SetMouseCursor(MouseCursorTypes.Normal);
         }
      }
      break;
   
      case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
         if (component == graphCanvas) {
            SetMouseCursor(MouseCursorTypes.DraggingHand);
            dragging = true;
            moveMidpoint(x, y);
         }
      }
      break;
   
      case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
         dragging = false;
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
         redrawGraph();
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
         polyVoiceCount = (int) longValue;
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
   double exponent = (modding || smoothing) ? calculateExponent() : lastExponent;

   double inputVoltageUnit = inputJackL.GetValue() * 0.2;
   double outputVoltage = rectification.convert(inputVoltageUnit, exponent) * 5.0;
   
   outputJackL.SetValue(outputVoltage);
   
   if (inputJackR.IsConnected()) {
      inputVoltageUnit = inputJackR.GetValue() * 0.2;
      outputVoltage = rectification.convert(inputVoltageUnit, exponent) * 5.0;
   }
   outputJackR.SetValue(outputVoltage);
   
   if (!processPoly) return;
   
   for (int i=0; i<polyVoiceCount; i++) {
     inputVoltageUnit = polyInputJack.GetPolyValue(i) * 0.2;
     outputVoltage = rectification.convert(inputVoltageUnit, exponent) * 5.0;
     polyOutputJack.SetPolyValue(i, outputVoltage);
   }
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
      if (component == invertSwitch) {
        return rectification.getName();
      }


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
private VoltageLabel textLabel16;
private VoltageLabel textLabel13;
private VoltageLabel textLabel17;
private VoltageLabel textLabel15;
private VoltageLabel textLabel14;
private VoltageAudioJack outputJackR;
private VoltageAudioJack inputJackR;
private VoltageLabel textLabel12;
private VoltageLabel textLabel11;
private VoltageLabel textLabel10;
private VoltageLabel textLabel9;
private VoltageLabel textLabel8;
private VoltageLabel textLabel7;
private VoltageLabel textLabel6;
private VoltageLabel textLabel5;
private VoltageLabel textLabel4;
private VoltageLabel textLabel2;
private VoltagePolyJack polyOutputJack;
private VoltagePolyJack polyInputJack;
private VoltageLabel textLabel1;
private VoltageAudioJack midpointYModJack;
private VoltageKnob midpointYModAmountKnob;
private VoltageAudioJack midpointXModJack;
private VoltageKnob midpointXModAmountKnob;
private VoltageCanvas graphCanvas;
private VoltageSwitch invertSwitch;
private VoltageKnob midpointYKnob;
private VoltageKnob midpointXKnob;
private VoltageAudioJack outputJackL;
private VoltageAudioJack inputJackL;


//[user-code-and-variables]    Add your own variables and functions here
private double midpointX;
private double midpointY;
private double targetMidpointX;
private double targetMidpointY;
private double midpointXModAmount;
private double midpointYModAmount;
private double moddedMidpointX;
private double moddedMidpointY;
private Rectification rectification = Rectification.OFF;
private double lastExponent = 1.0;
private boolean modding;
private static final Color SONAR_GREEN = new Color(64, 255, 64, 128);
private boolean processPoly;
private int polyVoiceCount;
private boolean dragging;
private boolean smoothing;

private double calculateExponent() {
   if (smoothing) {
      midpointX = (0.9995 * midpointX) + (0.0005 * targetMidpointX);
      midpointY = (0.9995 * midpointY) + (0.0005 * targetMidpointY);
      if (Math.abs(targetMidpointX - midpointX) < 0.001
         && Math.abs(targetMidpointY - midpointY) < 0.001) {
         midpointX = targetMidpointX;
         midpointY = targetMidpointY;
         smoothing = false;
      }
   }
   
   moddedMidpointX = Math.min(0.999,
      Math.max(0.001,
         midpointX + (midpointXModAmount * midpointXModJack.GetValue() * 0.2)
     )
   );
   moddedMidpointY = Math.min(0.999,
      Math.max(0.001,
         midpointY + (midpointYModAmount * midpointYModJack.GetValue() * 0.2)
      )
   );
   lastExponent = Math.log(moddedMidpointY) / Math.log(moddedMidpointX);
   return lastExponent;
}

private enum Rectification {
  
  OFF() {
     @Override
     public String getName() { return "Off"; }
     
     @Override
     public double convert(double x, double exponent) {
        return Math.pow(Math.abs(x), exponent) * Math.signum(x);
     }
  },
  
  ON() {
     @Override
     public String getName() { return "On"; }
     
     @Override
     public double convert(double x, double exponent) {
        return Math.pow(Math.abs(x), exponent);
     }
  },
  
  ON_PLUS_DC() {
     @Override
     public String getName() { return "On + DC"; }
     
     @Override
     public double convert(double x, double exponent) {
        return (Math.pow(Math.abs(x), exponent) * 2.0) - 1.0;
     }
  };
  
  public static Rectification of(double switchValue) {
     switch((int) switchValue) {
        case 0: return OFF;
        case 1: return ON;
        default: return ON_PLUS_DC;
      }
  }
  
  public abstract String getName();
  public abstract double convert(double x, double exponent);
}

private void redrawGraph() {
   Graphics2D g = graphCanvas.GetGraphics();
   int width = graphCanvas.GetBitmapWidth() - 1;
   int height = graphCanvas.GetBitmapHeight() - 1;
   
   g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
   g.setBackground(Color.BLACK);
   g.clearRect(0, 0, width + 1, height + 1);
                
   double xDelta = 1.0 / width;
   double x = xDelta;
   
   double exponent = lastExponent;
   
   GeneralPath polyLine = 
       new GeneralPath(GeneralPath.WIND_EVEN_ODD, width);
   polyLine.moveTo(0.0, (double) height);
   
   for (int i=1; i<width; i++) {
     double y = Math.pow(x, exponent);
     x += xDelta;
     double vpos = (height - (height * y));
     polyLine.lineTo(i, vpos);
     g.setPaint(new GradientPaint(i, height, Color.BLACK, i, (float) vpos, SONAR_GREEN));
     g.drawLine(i, height, i, (int) vpos);
   }
   
   polyLine.lineTo(width, 0.0);
      
   g.setColor(Color.GREEN);
   g.draw(polyLine);
    
   g.setColor(Color.YELLOW);
   Shape circle = new Ellipse2D.Double(
      (moddedMidpointX * width) - 2.0,
      height - (moddedMidpointY * height) - 2.0,
      4.0, 4.0);
   g.draw(circle);
   
   g.dispose();
}

private void moveMidpoint(int x, int y) {
   double hpos = (double) x / (graphCanvas.GetBitmapWidth() - 1);
   double vpos = 1.0 - ((double) y / (graphCanvas.GetBitmapHeight() - 1));

   midpointXKnob.SetValue(Math.max(0.001, Math.min(0.999, hpos)));
   midpointYKnob.SetValue(Math.max(0.001, Math.min(0.999, vpos)));
}

//[/user-code-and-variables]
}

 