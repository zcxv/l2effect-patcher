class 2042 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect24
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.it_antidote_ta'
	End Object
	Desc="해독제" //Antidote
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect24',SpecificStage=0)
}