class 2165 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect0
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=0.200000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mo_focus_sonic_ta'
	End Object
	Desc="에너지 스톤" //Stone Energy
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect0',SpecificStage=0)
}