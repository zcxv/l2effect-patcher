class 4380 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect17
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.sa_mass_frenzy_ta'
		bOnMultiTarget=True
	End Object
	Desc="결투장 CP 회복" //CP recovery cartel
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect17',SpecificStage=0)
}